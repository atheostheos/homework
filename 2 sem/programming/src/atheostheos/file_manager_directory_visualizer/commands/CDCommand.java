package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CDCommand extends AbstractCommand{

    public CDCommand() {
        name = "cd";
    }

    @Override
    public String toString() {
        return String.format("%-10s Displays the current directory and lets you switch to other directories.",
                name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParameters params) {
        Path goTo = Paths.get(params.getArgs().get(0));
        Path curPath = manager.getDirectory().toPath();
        File newFile = curPath.resolve(goTo).normalize().toFile();
        if (!newFile.exists()) {
            System.out.println("Such file does not exist.");
            return false;
        }
        manager.setDirectory(newFile);
        return true;
    }

}
