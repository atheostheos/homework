package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

public class ExitCommand extends AbstractCommand{

    public ExitCommand() {
        name = "exit";
    }

    @Override
    public String toString() {
        return String.format("%-10s Terminates program.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParameters params) {
        System.exit(0);
        return true;
    }
}
