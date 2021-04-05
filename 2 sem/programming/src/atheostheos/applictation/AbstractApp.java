package atheostheos.applictation;

public abstract class AbstractApp implements App {

    public AbstractApp() {
        init();
        start();
    }

    public abstract void init();
    public abstract void start();
}
