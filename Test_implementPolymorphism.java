public class Test_implementPolymorphism {
    public static void main(String[] args)
    {
        worker tom = new worker("tengzhou",34);
        tom.work();
        tom = new police("tengzhou", 45, "police");
        tom.work();
        tom = new techer("tengzhou" , 34, "techer");
        tom.work();
    }
}
class worker {
    protected String name;
    protected int age;

    public worker(String n, int a) {
        name = n;
        age = a;
    }
    public void work(){
    }
}

final class police extends worker {
    public police(String n, int a, String type) {
        super(n, a);
        System.out.println("my work type is " + type);
    }
    public void work() {
        System.out.println("police work");
    }
    public void say()
    {
        System.out.println("i am police");
    }
}

final class techer extends worker {
    public techer(String n, int a, String type) {
        super(n, a);
        System.out.println("my work type is " + type);
    }
    public void work(){
        System.out.println("teacher work");
    }
    public void say() {
        System.out.println("i am teacher");
    }
}
