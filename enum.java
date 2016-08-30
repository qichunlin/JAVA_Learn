import java.util.*;
//enum type is a class in java
//season is a class
enum season {
    //spring,summer,fall,winter are child class of season
    spring("Spring") {
    }
    ,summer("Summer"),fall("Fall"),winter("Winter");
    private String name;
    private season(String _name) {
        this.name = _name;
    };
    public String getSeason() {
        return this.name;
    };
}

class Enum {
    public static void main(String args[]) {
        season choose = season.spring;
        System.out.println(choose.getSeason()+" "+season.spring.name()+" "+choose.getClass());
    }
}
