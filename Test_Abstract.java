/**
 * Created by OriginalS on 2016/11/18.
 */
public class Test_Abstract {
    public static void main(String[] args)
    {
        Cat kitty = new Cat("Kitty");
        Little_Cat Lily = new Little_Cat("Lily",1997);
        kitty.Cry();
        kitty.Walk();
        System.out.println(kitty.Info());
        Lily.Cry();
        Lily.Walk();
        Lily.Info();
    }
}

abstract class Animal{
    protected void Cry(){}
    protected void Walk(){}
    protected String Info(){return "Animal_Name";}
}

class Cat extends Animal {
    protected final String Name;
    public Cat (String Cat_Name)
    {
        Name = Cat_Name;
    }
    public void Cry(){
        System.out.println("喵");
    }
    public void Walk(){
        System.out.println("Walk Walk Walk!");
    }
    public String Info()
    {
        return Name;
    }
    public void Eat()
    {
        System.out.print("Eating");
    }
    public static void main(String[] args)
    {
        Cat Hello = new Cat("HUM");
        Hello.Cry();
        Hello.Walk();
    }
}

class Little_Cat extends Cat{
    private int Year;
    public Little_Cat(String Cat_Name, int Birthday) {
        super(Cat_Name);
        Year = Birthday;
    }
    public void Cry(){
        System.out.println("喵呜");
    }
    public String Info()
    {
        System.out.printf("%s %d", Name,Year);
        return Name;
    }
}

