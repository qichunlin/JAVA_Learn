/**
 * Created by OriginalS on 2017/2/2.
 */
interface Dosometing {
    void say();
    void go();
}

public class Noname {
    public static void main(String[] args) {
        test b = new test() {
          public void say() {
              System.out.println("noting!");
          }
        };
        Dosometing a = new Dosometing() {
            public void say() {
                System.out.println("noting!");
            }
            public void go() {
                System.out.print("hello");
            }
        };
        b.say();
        a.say();
        a.go();
    }
}

class test {
    public void say() {
        int i = 1;
    }
}

