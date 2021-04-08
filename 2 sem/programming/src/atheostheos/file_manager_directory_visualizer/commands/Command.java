package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

public interface Command {
    boolean process(FileManager manager, CommandParamsContainer params);
    String getName();
}
