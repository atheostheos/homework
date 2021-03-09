package ru.kpfu.itis.tabs;

public class HelpTab extends Tab {

    public HelpTab() {
        super("Help", "None");
    }

    @Override
    public void show() {
        System.out.print("x y - choose cell\n" +
                "+n - create new spreadsheet with size n\n" +
                "n - choose spreadsheet number n\n" +
                "TabName - go to chosen tab\n" +
                "An params - use method in chosen tab\n" +
                "G - toggle graph\n" +
                "Alpha version - menu settings, functions and graph build are unavailable\n");
    }

    @Override
    public void processCommand(String command) {

    }
}
