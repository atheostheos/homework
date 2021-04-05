package atheostheos.file_manager_directory_visualizer;

import atheostheos.file_manager_directory_visualizer.commands.Command;

import java.io.File;
import java.util.Set;

public interface FileManager {
    void processCommand(String command);

    File getDirectory();
    void setDirectory(File toFile);
    Set<Command> getCommands();
}
