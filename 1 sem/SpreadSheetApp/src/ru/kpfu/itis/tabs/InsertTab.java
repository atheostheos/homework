package ru.kpfu.itis.tabs;

public class InsertTab extends Tab {

    public InsertTab() {
        super("Insert", "None");
    }

    public void show() {
        System.out.println("Alpha version. Insert is unavailable.");
    }

    @Override
    public void processCommand(String command) {

    }
}
