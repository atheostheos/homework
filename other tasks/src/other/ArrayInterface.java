import java.util.Scanner;

public class ArrayInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        String[] notes = new String[n];
        int counter = 0;
        boolean flagStatus;
        while(true) {

            System.out.print("Please enter command: ");
            String command = sc.nextLine();
            flagStatus = true;


            switch (command) {
                case "add":
                    flagStatus = add(counter, notes, sc);
                    if (flagStatus) counter++;
                    break;

                case "remove":
                    flagStatus = remove(counter, notes, sc);
                    if (flagStatus) counter--;
                    break;

                case "max":
                    System.out.println(getMax(counter, notes, sc));
                    break;

                case "print":
                    printNotes(counter,notes);
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unknown command! Try again");
            }

            if (!flagStatus) System.out.println("Command not applicable.");
        }
    }

    public static boolean add(int counter, String[] notes, Scanner sc){
        if (counter < notes.length) {
            notes[counter] = sc.nextLine();
            return true;
        } else {
            return false;
        }
    }

    public static boolean remove(int counter, String[] notes, Scanner sc){
        if (counter > 0) {
            notes[counter-1] = null;
            return true;
        } else {
            return false;
        }
    }

    public static String getMax(int counter, String[] notes, Scanner sc) {
        int iMax = 0;
        for (int i = 0; i < counter; i++) {
            if (notes[i].length() > notes[iMax].length()) iMax = i;
        }
        return notes[iMax];
    }

    public static void printNotes(int counter, String[] notes) {
        for (int i = 0; i < counter; i++) {
            System.out.print(notes[i] + " ");
        }
        System.out.print("\n");
    }
}
