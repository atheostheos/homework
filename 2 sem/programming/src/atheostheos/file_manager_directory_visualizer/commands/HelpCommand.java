package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        name = "help";
    }

    @Override
    public String toString() {
        return String.format("%-10s Displays help text for commands.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParameters params) {
        for (Command command: manager.getCommands()) {
            System.out.println(command);
        }
        return true;
    }
}
