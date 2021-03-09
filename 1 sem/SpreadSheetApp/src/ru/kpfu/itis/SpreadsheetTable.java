package ru.kpfu.itis;

import java.util.ArrayList;

public class SpreadsheetTable {
    public ArrayList<Spreadsheet> spreadsheets;
    protected int spreadsheetIndex;
    protected Spreadsheet spreadsheet;

    public SpreadsheetTable(int spreadSheetSize) {
        this.spreadsheets = new ArrayList<Spreadsheet>(1);
        spreadsheets.add( new Spreadsheet(spreadSheetSize));
        spreadsheetIndex = 0;
        spreadsheet = spreadsheets.get(spreadsheetIndex);
    }

    public void addSpreadsheet(int size) {
        spreadsheets.add(new Spreadsheet(size));
    }

    public void show() {
        spreadsheet.show();
        System.out.print('\n');
        for (int i = 0; i < spreadsheets.size(); i++) {
            if (i == spreadsheetIndex) {
                System.out.printf(" |%d| ",i+1);
            } else {
                System.out.printf(" %d ", i+1);
            }
        }
        System.out.println("+");
    }

    public void setSpreadsheetIndex(int x) {
        if ((x > spreadsheets.size()) || (x < 0)) {
            spreadsheetIndex = 0;
        } else {
            spreadsheetIndex = x-1;
        }
        spreadsheet = spreadsheets.get(spreadsheetIndex);
    }
}
