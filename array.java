import java.util.Arrays;
class array {
    public static void main(String args[]) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = i;
            System.out.println(a[i]);
        }
        for (int e : a) {
            System.out.println(e);
        }
        a = new int[] {1,2,3,4}; //重新初始化
        for (int e : a)
            System.out.println(e);
        //数组拷贝
        //引用同一个数组
        int[] b = a;
        b[0] = 5;
        System.out.println("a[0] is "+a[0]);

        int[] c = Arrays.copyOf(a, 2*a.length);
        for (int w : c) {
            System.out.println(w);
        }
        for (String z : args)
            System.out.println(z);
    }
}
