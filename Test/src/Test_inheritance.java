
/**
 * Created by OriginalS on 2016/11/17.
 */
public class Test_inheritance {
    public static void main(String[] args)
    {
        Child a = new Child();
        a.Awake("OriginalS");
        a.Awake(10);
    }
}

class Father {
    private String name;
    public void Awake(String me)
    {
        name = me;
        System.out.println("i am "+name);
    }
}

class Child extends Father {
    void Awake(int a)
    {
        System.out.print(a);
    }
}

