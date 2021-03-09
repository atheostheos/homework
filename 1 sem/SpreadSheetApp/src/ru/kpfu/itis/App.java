package ru.kpfu.itis;

import java.util.regex.Pattern;

import ru.kpfu.itis.menu.Menu;
import ru.kpfu.itis.tabs.Tab;

public class App {
    public Menu menu;
    public Ribbon ribbon;
    public Graph graph;
    public SpreadsheetTable sprtbl;
    protected boolean isGraphVisible;


    public App(Menu menu, Tab[] tabs, int spreadsheetSize, Graph graph) {
        this.menu = menu;
        this.ribbon = new Ribbon(tabs);
        this.graph = graph;
        this.sprtbl = new SpreadsheetTable(spreadsheetSize);
        isGraphVisible = false;
    }

    public void processCommand(String command) {
        int commandLength = command.length();

        ribbon.setTabIndex(command);

        ribbon.tab.processCommand(command);

        if (Pattern.matches("\\+\\d+", command)) {
            String sub = command.substring(1,commandLength);
            int size = Integer.parseInt(sub);
            sprtbl.addSpreadsheet(size);
        }

        if (Pattern.matches("\\d+", command)) {
            int index = Integer.parseInt(command);
            sprtbl.setSpreadsheetIndex(index);
        }

        if (Pattern.matches("\\d+ \\d+", command)) {
            String[] coords = command.split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            sprtbl.spreadsheet.setCellIndex(x,y);
        }

        if (Pattern.matches("G", command)) {
            isGraphVisible = !isGraphVisible;
        }

        if (Pattern.matches(":=.*", command)) {
            sprtbl.spreadsheet.cell.value = command.substring(2,commandLength);
        }

        if (command.equals("exit")) System.exit(0);
    }

    public void show() {
        menu.show();
        Util.printLine(40);
        ribbon.show();
        Util.printLine(40);
        System.out.print('\n');
        sprtbl.show();
        System.out.print('\n');
        if (isGraphVisible) {
            graph.show();
            System.out.print('\n');
        }
        System.out.print(">>");
    }
}
