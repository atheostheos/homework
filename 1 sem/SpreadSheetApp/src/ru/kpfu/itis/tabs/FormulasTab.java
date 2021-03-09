package ru.kpfu.itis.tabs;

import ru.kpfu.itis.Cell;
import ru.kpfu.itis.Spreadsheet;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FormulasTab extends Tab {

    public FormulasTab() {
        super("Formulas", "Sum","Arithmetic Mean");
    }

    @Override
    public void show() {
        for(int i = 0; i < methodList.length; i++) {
            System.out.printf("A%d. %s \n",(i+1),methodList[i]);
        }
    }

    @Override
    public void processCommand(String command) {

    }

    public boolean sum(Cell result, Cell[] cells) {
        double sum = 0.0;
        for (int i = 0; i < cells.length; i++) {
            try {
                sum += Double.parseDouble(cells[i].getValue());
            }
            catch (Exception e) {
                result.setValue("NaN");
                return false;
            }
        }
        result.setValue(String.valueOf(sum));
        return true;
    }

    public boolean arithmeticMean(Cell result, Cell[] cells) {
        if (sum(result, cells)) {
            double mean = Double.parseDouble(result.getValue());
            mean /= cells.length;
            result.setValue(String.valueOf(mean));
            return true;
        }
        return false;
    }


}
