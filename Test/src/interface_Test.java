/**
 * Created by OriginalS on 2017/1/16.
 */
public class interface_Test {
    public static void main(String... args) {
        doctor a = new doctor();
        a.getinfo("tengzhou", 18);
        a.outinfo();
        a.maninfo();
    }
}
interface work<T> {
    void getinfo(String name, int age);
    void outinfo();
}

interface man<T> {
    void maninfo();
}

class doctor implements work , man {
    private String myname;
    private int myage;
    public void getinfo(String name, int age) {
        myname = name;
        myage = age;
    }
    public void outinfo() {
        System.out.println("my name is " + myname + ",my age is "+ myage);
    }
    public void maninfo() {
        System.out.println("hello, i am a doctor");
    }
}
