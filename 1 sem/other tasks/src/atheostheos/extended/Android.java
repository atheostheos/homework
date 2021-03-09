package atheostheos.extended;

public class Android extends Robot {
    protected String name;

    public Android(String model, String serialNum, String authPhrase, String name) {
        super(model, serialNum, authPhrase);
        this.name = name;
    }

    public void sayName() {
        if (power) System.out.println(name);
    }
}
