import java.util.*;
import java.io.Console;

class io {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        season hello = season.spring;
        System.out.println("Hello,what is your name?");
        String name = in.nextLine();

        System.out.println("Your age?");
        int age = in.nextInt();

        System.out.println("your name:"+name+"\nyour age:"+age);
        System.out.println("now,enter your password:");

        Console get = System.console();
        char[] passwd = get.readPassword("Password:");
        System.out.println(passwd);

    }
}
