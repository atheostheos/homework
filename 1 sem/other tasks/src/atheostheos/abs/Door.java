package atheostheos.abs;

public abstract class Door {
    protected String material;
    protected int height;
    protected int width;

    public abstract void open();
    public abstract void close();
    public abstract void unlock();
}