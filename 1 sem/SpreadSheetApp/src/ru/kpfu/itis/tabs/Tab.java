package ru.kpfu.itis.tabs;

public abstract class Tab {
    public final String NAME;
    protected String[] methodList;


    public Tab(String name, String...methodList) {
        this.NAME = name;
        this.methodList = methodList;
    }

    public abstract void show();

    public abstract void processCommand(String command);

}
