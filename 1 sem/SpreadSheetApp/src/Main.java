import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import ru.kpfu.itis.*;
import ru.kpfu.itis.menu.*;
import ru.kpfu.itis.tabs.*;


public class Main {

    public static void main(String[] args) {

        String[] fontList = {"Times New Roman", "Roboto", "Sans serif"};
        Tab[] tabs = {new HomeTab(fontList), new InsertTab(), new FormulasTab(), new ReviewTab(), new HelpTab()};
        String[] tabNames = {"Home", "Insert", "Formulas", "Review", "Help"};
        App app = new App(new Menu(), tabs,5, new Graph(5));

        Scanner sc = new Scanner(System.in);
        String command;

        while(true) {
            app.show();

            command = sc.nextLine();

            app.processCommand(command);
        }
    }
}
