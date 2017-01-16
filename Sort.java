import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        int[] a;
        int number;
        System.out.println("input the size of array:");
        Scanner get = new Scanner(System.in);
        a = new int[get.nextInt()];
        for (int n = 0; n < a.length; n++)
            a[n] = get.nextInt();
        for (int b: a)
            System.out.print(b);
        number = Scan(a);
    }
    public static int Scan(int[] array){
        int k = 0;
        int count = 1;
        for (int n = 0; n < array.length; n++){
            if (n != 0 && k > array[n])
                count++;
            k = array[n];
        }
        System.out.print(count);
        return count;
    }
}
