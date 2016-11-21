public class Test_implementPolymorphism {
    public static void main(String[] args)
    {
        worker tom = new worker();
        tom.work();
        tom = new police();
        tom.work();
        tom = new techer();
        tom.work();
    }
}

class worker {
    public void work(){
    }
}

class police extends worker {
    public void work() {
        System.out.println("police work");
    }
    public void say()
    {
        System.out.println("i am police");
    }
}

class techer extends worker {
    public void work(){
        System.out.println("teacher work");
    }
    public void say() {
        System.out.println("i am teacher");
    }
}
