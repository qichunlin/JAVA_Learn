/**name,toString,valueOf
 *equals
 *clone
 * ordinal
 */
enum number {
    zero(0),one(1),two(2);
    int n;
    number(int i) {
        this.n = i;
    }
    public int getValue(){
        return this.n;
    }
}
interface People_State {
    String getState();
    State_Enum ChangeState();
}

enum  State_Enum implements People_State {
    normal("正常"), stop("停止");
    private final String state;

    State_Enum(String s) {
        this.state = s;
    }

    public String toString() {
        return state;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public State_Enum ChangeState() {
        if (this == normal)
            return stop;
        else
            return normal;
    }
}
public class Test_Enum {
    public static void main(String[] args) {
        number z = number.zero;
        State_Enum state = State_Enum.normal;

        System.out.println(z.getValue());
        System.out.println(z);
        System.out.println(number.one);
        switch (z) {
            case zero:
                System.out.println(0);
                break;
            case one:
                System.out.println(1);
                break;
            case two:
                System.out.println("2");
                break;
        }
        //equals
        if (z.equals(number.one)) {
            System.out.println("equal!");
        } else {
            System.out.println("unequal");
        }
        //valueOf
        System.out.println(number.valueOf("zero"));
        //ordinal
        System.out.println(z.ordinal()); //the index of values

        System.out.println(state.toString());
        state = state.ChangeState();
        System.out.println(state.getState());
    }
}
