//test the control statement of java
class control {
    public static void main(String args[]) {
        //if...else...
        if (1 > 2)
            System.out.println("1 > 2");
        else
            System.out.println("2 > 1");

        //loop statement
        int i = 0;

        //while
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        //do...while...
        do {
            System.out.println(i);
            i--;
        } while(i > 0);

        //for...
        for (int z = 0; z < 10; z++) {
            System.out.println(z);
        }
        String word = "hello";

        //choose statement
        switch (word) {
            case "hello":
                System.out.println(word);
                break;
            case "good":
                System.out.println(word);
                break;
            default:break;
        }
    }
}
