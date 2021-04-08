package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

import java.io.File;

public class DIRCommand extends AbstractCommand {

    public DIRCommand() {
        name = "dir";
    }

    @Override
    public String toString() {
        return String.format("%-10s Displays all folders and files within the current directory.",
                name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParamsContainer params) {
        File dir = manager.getDirectory();
        File[] children = dir.listFiles();
        if (children == null) return false;
        for (File file : children) {
            System.out.println(file.getName());
        }
        return true;
    }
}
