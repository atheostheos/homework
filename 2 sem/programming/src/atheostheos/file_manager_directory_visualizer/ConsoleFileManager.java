package atheostheos.file_manager_directory_visualizer;

import atheostheos.file_manager_directory_visualizer.commands.RegexCommandParamsContainer;
import atheostheos.file_manager_directory_visualizer.commands.Command;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ConsoleFileManager implements FileManager {
    protected HashMap<String, Command> commands;
    protected File directory;

    public ConsoleFileManager(File directory, HashMap<String, Command> commands) {
        this.directory = directory;
        this.commands = commands;
    }

    @Override
    public void processCommand(String line) {
        RegexCommandParamsContainer params = new RegexCommandParamsContainer(line);
        try {
            commands.get(params.getCommand()).process(this, params);
        } catch (NullPointerException e) {
            System.out.printf("Command \"%s\" does not exist\n", params.getCommand());
        } catch (Exception e){
            System.out.println("Unable to process command");
        }
    }

    @Override
    public File getDirectory() {
        return directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
    }

    @Override
    public Set<Command> getCommands() {
        return new HashSet<Command>(commands.values());
    }
}
