package ru.kpfu.itis.menu;

import ru.kpfu.itis.menu.Settings;

public class Menu {
    protected Settings settings;

    public Menu() {
        this.settings = new Settings("english", "guest");
    }

    public void show() {
        System.out.println(settings.user);
    }

    public Menu(Settings settings) {
        this.settings = settings;
    }

    public void openFile() {}
    public void newFile() {}
}
