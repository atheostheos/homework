package ru.kpfu.itis.tabs;

import ru.kpfu.itis.Cell;
import ru.kpfu.itis.Util;

import java.util.regex.Pattern;
import java.util.Arrays;

public class HomeTab extends Tab {
    protected String[] fontList;
    protected String[] alignmentList = {"left", "right", "center"};
    protected String font;
    protected String alignment;

    public HomeTab(String[] fontList) {
        super("Home", "Change font", "Change alignment");
        this.fontList = fontList;
        font = fontList[0];
        alignment = alignmentList[1];
    }

    @Override
    public void show() {
        System.out.println("Font: "+font);
        System.out.println("Alignment: "+ alignment);
        System.out.printf("A%d. %s: %s \n", 1, methodList[0],Arrays.toString(fontList));
        System.out.printf("A%d. %s: %s \n", 2, methodList[1],Arrays.toString(alignmentList));
    }

    @Override
    public void processCommand(String command) {
        if (Pattern.matches("A1 \\w+", command)) {
            String sub = command.substring(3,command.length());
            setFont(sub);
        }

        if (Pattern.matches("A2 \\w+", command)) {
            String sub = command.substring(3,command.length());
            setAlignment(sub);
        }
    }

    public String[] getFontList() {
        return fontList;
    }

    public String[] getAlignmentList() {
        return alignmentList;
    }

    public void setFont(String font) {
        if (Util.isInArray(font, fontList))
            this.font = font;
    }

    public void setAlignment(String alignment) {
        if (Util.isInArray(alignment, alignmentList))
            this.alignment = alignment;
    }
}
