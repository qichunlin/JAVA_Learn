import java.util.ArrayList;
import java.util.PrimitiveIterator;

/**
 * Created by OriginalS on 2017/1/15.
 */
public class Test_ArrayClass {
    public static void main(String[] args) {
        ArrayList<String> good = new ArrayList<> (10);
        good.add(0,"hello");
        good.add(1,"yes");
        if(good.lastIndexOf("hello") == 10) {
            System.out.println("yes!");
        } else {
            System.out.println("no!");
        }
        System.out.print(good.size());
        good.add("nice!");
    }
}
