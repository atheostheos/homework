package ru.kpfu.itis;

import ru.kpfu.itis.tabs.Tab;

public class Ribbon {
    public final Tab[] tabs;
    public final String[] tabNames;
    protected int tabIndex;
    public Tab tab;

    public Ribbon(Tab[] tabs) {
        this.tabs = tabs;
        tabNames = new String[tabs.length];

        for (int i = 0; i < tabs.length; i++) {
            tabNames[i] = tabs[i].NAME;
        }
        tabIndex = tabs.length-1;
        tab = tabs[tabIndex];
    }

    public void show() {
        for (int i = 0; i < tabNames.length; i++) {
            if (i == tabIndex) {
                System.out.printf(" |%s| ", tabNames[i]);
            } else {
                System.out.printf(" %s ", tabNames[i]);
            }
        }
        System.out.print("\n\n");
        tab.show();
    }

    public void setTabIndex(String name) {
        for (int i = 0; i < tabs.length; i++) {
            if (name.equals(tabNames[i]))
                tabIndex = i;
                tab = tabs[tabIndex];
        }
    }

}
