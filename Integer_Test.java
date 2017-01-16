import java.util.ArrayList;

/**
 * Created by OriginalS on 2017/1/16.
 */
public class Integer_Test {
    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<>(20);
        Integer a = 3;
        int b = a.intValue();
        String x = a.toString();
        x = a.toString(a,2);
        System.out.print(x);
    }
}
