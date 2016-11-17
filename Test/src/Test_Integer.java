/**
 * Created by OriginalS on 2016/11/17.
 */
import java.math.BigInteger;
public class Test_Integer {
    public static void main(String[] args){
        BigInteger a = BigInteger.valueOf(100);
        for (int i = 10; i < 1000 ; i++)
            a = a.add(a);
        System.out.print(args[0]);
        System.out.println(a);
    }
}
