import java.util.Scanner;

public class BankersAlgorithm {
    int[] Available;
    int[][] Max;
    int[][] Allocation;
    int[][] Need;
    int[] Request;
    int[] Work;

    public BankersAlgorithm() {
        do {
            init();
        }while(!CheckSafety());
    }

    void init() {
        Scanner in = new Scanner(System.in);
        int i, j;

        System.out.println("输入资源种类:");
        j = in.nextInt();
        System.out.println("输入进程的数量:");
        i = in.nextInt();

        Available = new int[j];
        Max = new int[i][j];
        Allocation = new int[i][j];
        Need = new int[i][j];
        Request = new int[j];

        System.out.println("输入最大需求矩阵:");
        for(int[] k: Max) {
            for(int v: k)
                v = in.nextInt();
        }
        System.out.println("输入分配矩阵:");
        for(int[] k: Allocation) {
            for(int v: k)
                v = in.nextInt();
        }
        for(int k = 0; k < i; k++) {
            for (int v = 0; v < j; v++)
                Need[k][v] = Max[k][v] - Allocation[k][v];
        }
        System.out.println("输入可分配资源:");
        for(int k: Available)
            k = in.nextInt();
        Work = Available;
    }

    public boolean RequestSometing() {
        Scanner in = new Scanner(System.in);
        int i;
        System.out.println("输入请求的进程序号:");
        i = in.nextInt();
        boolean test = false;
        do {
            System.out.println("输入请求的资源数:");
            for(int n: Request)
                n = in.nextInt();
            for(int n = 0; n < Available.length; n++)
                test = Available[n] < Request[n];
            if (test) continue;
            for(int n = 0; n < Request.length; n++)
                test = Need[i][n] < Request[n];
        } while(test);

        int[][] Need_C = Need;
        int[][] Allocation_C = Allocation;
        Work = Available;

        for (int z = 0; z < Request.length; z++) {
            Need[i][z] -= Request[z];
            Work[z] -= Request[z];
            Allocation[i][z] += Request[z];
        }
        if(CheckSafety())
            return true;
        else {
            Need = Need_C;
            Allocation = Allocation_C;
            return false;
        }
    }

    boolean CheckSafety() {
        boolean[] mark = new boolean[Need.length];
        for(boolean i: mark)
            i = false;

        int pos = Check(mark);
        while (pos != -1 && pos != -2) {
            mark[pos] = true;
            for(int w = 0; w < Work.length; w++)
                Work[w] += Allocation[pos][w];
            pos = Check(mark);
        }
        return pos == -2;
    }

    int Check(boolean[] mark) {
        int fit = -1;
        int z;
        int count = 0;
        for(z = 0; z < Need.length; z++) {
            boolean test = true;
            if (mark[z])
                continue;
            for(int k = 0; k < Work.length; k++) {
                count++;
                if(Need[z][k] > Work[k]) {
                    test = false;
                    break;
                }
            }
            if (test)
                return z;
        }
        return count > 0? -1: -2;
    }
    public static void main(String[] args) {
        BankersAlgorithm s = new BankersAlgorithm();
        if(s.RequestSometing())
            System.out.println("ok!");
        else
            System.out.println("false!");
    }
}