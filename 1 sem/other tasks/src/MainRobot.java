import atheostheos.extended.Android;
import atheostheos.extended.Terminator;
import atheostheos.extended.Firearm;


public class MainRobot {

    public static void main(String[] args) {

        Android droid1 = new Android("TR-04", "a456fd32", "password", "Gilbert");

        droid1.turnOn("password");
        System.out.println(droid1.isOn());
        droid1.sayName();

        Terminator droid2 = new Terminator("RXM-1", "bfa3c5a9", "anotherpassword", "Oliver");
        Firearm firearm = new Firearm("Diamond Back .357", 9);

        droid2.turnOn("password");
        System.out.println(droid2.isOn());
        droid2.turnOn("anotherpassword");
        droid2.giveFirearm(firearm);
        droid2.showFirearm();

    }
}
