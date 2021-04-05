package atheostheos.file_manager_directory_visualizer;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class DeprecatedConsoleFileManager {
    protected String DELIMITER = FileSystems.getDefault().getSeparator().equals("\\") ?
                                                "\\\\" : FileSystems.getDefault().getSeparator();
    protected File file;
    protected ArrayDeque<String> sequence;
    protected Scanner sc;

    public DeprecatedConsoleFileManager(String path) {
        this.file= new File(path);
        if (!file.exists()) throw new IllegalArgumentException("Incorrect filepath");
        this.sequence = splitPath(this.file);
        sc = new Scanner(System.in);
    }

    public boolean processCommand() {
        System.out.print(file.getAbsolutePath() + " >> ");
        String command = sc.nextLine();
        String[] commandParameters = command.split(" ", 2);
        switch (commandParameters[0]) {
            case "cd":
                cd(commandParameters[1]);
                break;
            case "dir":
                dir();
                break;
            case "treedir":
                treeDir();
                break;
            case "mkdir":
                mkdir(commandParameters[1]);
                break;
            case "exit":
                return false;
            default:
                System.out.println("unknown command: " + commandParameters[0]);
                break;
        }
        return true;
    }

    public boolean cd(String path) {
        File file = goToFile(path);
        if (file.exists()) {
            this.file = file;
            this.sequence = splitPath(this.file);
        }
        else {
            System.out.println("Error: such file does not exist");
            return false;
        }
        return true;
    }

    public void dir() {
        String[] list = file.list();
        if (list == null) return;
        for(String el: list) {
            System.out.println("  " + el);
        }
    }

    public void treeDir() {
        TreeDirectory treeDirectory = new TreeDirectory(file);
        treeDirectory.show();
    }

    public boolean mkdir(String path) {
        File file = goToFile(path);
        return file.mkdir();
    }

    public File goToFile(String path) {
        ArrayDeque<String> newSequence = splitPath(path);
        ArrayDeque<String> oldSequence = sequence.clone();

        while (!newSequence.isEmpty() && newSequence.peekFirst().equals("..")) {
            newSequence.pollFirst();
            oldSequence.pollLast();
        }

        String oldPath = String.join(DELIMITER, oldSequence);
        String newPathPart = String.join(DELIMITER, newSequence);

        return new File(oldPath + DELIMITER + newPathPart);
    }

    protected ArrayDeque<String> splitPath(File file) {
        return splitPath(file.getAbsolutePath());
    }

    protected ArrayDeque<String> splitPath(String path) {
        ArrayDeque<String> sequence = new ArrayDeque<>();
        String[] splitPath;
        try {
            splitPath = path.split(DELIMITER);
        } catch (PatternSyntaxException e) {
            splitPath = new String[]{path};
        }
        for (String el: splitPath) {
            if (!el.equals(""))
                sequence.addLast(el);
        }
        return sequence;
    }

    public static void main(String[] args) {
        DeprecatedConsoleFileManager manager = new DeprecatedConsoleFileManager("C:\\Users\\coalm\\OneDrive\\Документы\\git\\homework\\2 sem\\programming");
        boolean works = true;
        while(works) {
            try {
                works = manager.processCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected exception, terminating program");
            }
        }
    }
}
