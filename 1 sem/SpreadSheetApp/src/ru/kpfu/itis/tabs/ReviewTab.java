package ru.kpfu.itis.tabs;

public class ReviewTab extends Tab {

    public ReviewTab() {
        super("Review", "None");
    }

    public void show() {
        System.out.println("Alpha version. Review is unavailable.");
    }

    @Override
    public void processCommand(String command) {

    }
}
