/**
 * Created by OriginalS on 2016/11/17.
 */
class Class_Test {
    public final static String name = "Test_Class";
    private final String man;
    private int Age;

    public Class_Test(String man_name) {
        man = man_name;
        Age = 23;
    }

    public static String Info(){
        //static method can not use the Non-static variable
        //return man; //error! man is not static
        return name;
    }

    public void Change(){
        //man = "TZ"; // you can't change the final variable when it is initialized
        Age = 45 + Age;
        System.out.println(Age);
    }
}
public class Test_Class{
    public static void main(String[] args)
    {
        Class_Test Hello = new Class_Test("OriginalS");
        Hello.Change();
        System.out.println(Hello.Info());
        Test_Integer a = new Test_Integer();
        String[] b = new String[] {"hello", "Good"};
        a.main(b); //Test Other Class
    }
}