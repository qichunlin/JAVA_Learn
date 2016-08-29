import java.util.*;

class good {
	enum season {
    spring("Spring"),summer("Summer"),fall("Fall"),winter("Winter");
    private String name;
    private season(String _name) {
        this.name = _name;
    };
    public String getSeason() {
        return this.name;
    };
}
    public static void main(String args[]) {
        season choose = season.spring;
        System.out.println(choose.getSeason()+" "+choose.name());
    }
}
