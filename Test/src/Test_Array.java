import java.util.Arrays;
import java.util.Scanner;

public class Test_Array {
    public static void main(String[] args)
    {
        // Create a Array
        //int[] a = new int[10];
        //int[] a = {1,2,3,4,5,6,7,8,9,10};
        int[] a;
        int c;
        //User can define the size of this Array
        Scanner b = new Scanner(System.in);
        c = b.nextInt();
        a = new int[c];
        for(int i = 0; i < c; i++)
            a[i] = i;
        System.out.printf("Length of A : %d\nNow initialization this Array Again\n",a.length);
        //initialize the array again
        a = new int[] {1,2};
        System.out.print("Array a:");
        for (int i : a)
            System.out.printf("%d ",i);
        System.out.print('\n');

        //Test Array Copy
        int[] d;
        d = Arrays.copyOf(a,a.length+10);
        //you can use Arrays.deepToString() to print a 2 dimensional array
        System.out.printf("Array b :%s",Arrays.toString(d));
        System.out.printf("\n new Array is ");
        d = a;
        a[1] = 1000;
        System.out.println(Arrays.toString(d));
    }
}
