package atheostheos.file_manager_directory_visualizer;

import atheostheos.applictation.AbstractApp;
import atheostheos.file_manager_directory_visualizer.commands.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App extends AbstractApp {
    protected FileManager manager;
    protected Scanner sc;

    public App() {
        super();
    }

    public void init() {
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new DIRCommand());
        commands.add(new CDCommand());
        commands.add(new TreeCommand());
        commands.add(new ExitCommand());
        commands.add(new MKDirCommand());
        commands.add(new RMCommand());
        commands.add(new TouchCommand());
        commands.add(new HelpCommand());
        HashMap<String, Command> commandsMap= new HashMap<>();
        for (Command com: commands) {
            commandsMap.put(com.getName(), com);
        }
        File directory = Paths.get(".").toAbsolutePath().normalize().toFile();
        this.manager = new ConsoleFileManager(directory, commandsMap);
        this.sc = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.printf("%s >> ",manager.getDirectory().getAbsolutePath());
            String line = sc.nextLine();
            manager.processCommand(line);
        }
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
