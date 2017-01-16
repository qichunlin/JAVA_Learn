import java.util.Scanner;
/**
 * Created by OriginalS on 2016/11/17.
 */
public class Test_IO {
    public static void main(String[] args){
        //Simple Test Of I/O
        //IN
        System.out.println("Hello,World");
        //equal
        System.out.print("Hello,World\n");

        //OUT
        //you should new a Scanner Object for read the input
        String a1;
        String a2;
        int b;
        boolean c;

        Scanner in = new Scanner(System.in);
        System.out.println("please input a String");
        a1 = in.nextLine(); // read a string
        System.out.println("please input a String again");
        a2 = in.next(); // read a string which include space
        System.out.print("input your age:");
        b = in.nextInt(); // read a integer
        c = in.hasNext(); //if the you input the EOF, it will return false
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b);
        System.out.println(c);
        System.out.printf("%s %s,%d,%b",a1,a2,b,c);
    }
}
