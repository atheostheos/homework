import java.util.Scanner;

public class ArrayInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        String[] notes = new String[n];
        int counter = 0;
        while(true) {

            System.out.println("Please enter command");
            String command = sc.nextLine();

            switch (command) {
                case "add":
                    if (counter > notes.length) {
                        System.out.println("Size limit. Can\'t add new elements");
                        counter--;
                    } else {
                    add(counter, notes, sc);
                    counter++;
                    }
                    break;

                case "remove":
                    if (counter <= 0) {
                        System.out.println("No elements found.");
                        counter++;
                    } else {
                        remove(counter, notes, sc);
                        counter--;
                    }
                    break;

                case "max":
                    System.out.println(getMaxLength(counter, notes, sc));
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
        }
    }

    public static void add(int counter, String[] notes, Scanner sc){
        notes[counter] = sc.nextLine();
    }

    public static void remove(int counter, String[] notes, Scanner sc){
        notes[counter] = null;
    }

    public static int getMaxLength(int counter, String[] notes, Scanner sc) {
        int max = 0;
        for (int i = 0; i < counter; i++) {
            if (notes[i].length() > max) max = notes[i].length();
        }
        return max;
    }

    public static void printNotes(int counter, String[] notes) {
        for (int i = 0; i < counter; i++) {
            System.out.print(notes[i] + " ");
        }
        System.out.println("\n");
    }
}
