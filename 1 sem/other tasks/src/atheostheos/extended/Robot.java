package atheostheos.extended;

public class Robot {
    protected final String MODEL;
    protected final String SERIAL_NUM;
    protected String authPhrase;
    protected boolean power = false;

    public Robot(String model, String serialNum, String authPhrase) {
        this.MODEL = model;
        this.SERIAL_NUM = serialNum;
        this.authPhrase = authPhrase;
    }

    public boolean isOn() {
        return power;
    }

    public boolean turnOn(String authPhrase) {
        if (this.authPhrase == authPhrase) {
            power = true;
            return true;
        }
        return false;
    }

    public boolean turnOff(String authPhrase) {
        if (this.authPhrase == authPhrase) {
            power = false;
            return true;
        }
        return false;
    }

    public boolean changeAuthPhrase(String oldAuth, String newAuth) {
        if (this.authPhrase == oldAuth) {
            this.authPhrase = newAuth;
            return true;
        }
        return false;
    }


}
