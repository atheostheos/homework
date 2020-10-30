package atheostheos.extended;

public class Terminator extends Android {
    protected Firearm firearm;

    public Terminator(String model, String serialNum, String authPhrase, String name) {
        super(model, serialNum, authPhrase, name);
    }

    public void giveFirearm(Firearm firearm) {
        if (power) this.firearm = firearm;
    }

    public void showFirearm() {
        if (power) this.firearm.showCharacteristics();
    }
}
