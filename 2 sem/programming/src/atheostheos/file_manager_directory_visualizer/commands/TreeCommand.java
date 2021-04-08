package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;
import atheostheos.file_manager_directory_visualizer.TreeDirectory;

public class TreeCommand extends AbstractCommand{

    public TreeCommand() {
        name = "tree";
    }

    @Override
    public String toString() {
        return String.format("%-10s Graphically displays the directory structure of a drive or path.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParamsContainer params) {
        TreeDirectory tree = new TreeDirectory(manager.getDirectory());
        tree.show();
        return true;
    }
}
