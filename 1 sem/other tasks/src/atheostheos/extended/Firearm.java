package atheostheos.extended;

public class Firearm {
    protected final String NAME;
    protected final int CALIBER;

    public Firearm(String name, int caliber) {
        this.NAME = name;
        this.CALIBER = caliber;
    }

    public void showCharacteristics() {
        System.out.printf("%s, caliber: %s.",NAME, CALIBER);
    }
}
