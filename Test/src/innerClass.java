import java.awt.font.ShapeGraphicAttribute;

/**
 * Created by OriginalS on 2017/2/1.
 * test for the inner class
 */
public class innerClass {
    public static void main(String[] args) {
    doSometing A = new doSometing();
    A.getinfo();
    doSometing.say V = A.new say();//create a inner class
        // if the inner class is static
        // you can create it use new say();
    V.SayName();
    V.SayAge();
    }
}
interface Info {
    void SayName();
    void SayAge();
}
class doSometing {
    private int age = 344;
    private String name = "Dell";

    final class say implements Info{
        public void say () {
            System.out.println("hello!");
        }
        public void SayName() {
            System.out.println(name);
        }
        public void SayAge() {
            System.out.println(age);
        }
    }

    void getinfo() {
        say T = new say();
        T.say();
        T.SayName();
        T.SayAge();
    }
}
