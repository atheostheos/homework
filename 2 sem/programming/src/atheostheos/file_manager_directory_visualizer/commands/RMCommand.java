package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RMCommand extends AbstractCommand{

    public RMCommand() {
        name = "rm";
    }

    @Override
    public String toString() {
        return String.format("%-10s Deletes a directory.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParamsContainer params) {
        Path goTo = Paths.get(params.getArgs().get(0));
        Path newPath = manager.getDirectory().toPath().resolve(goTo);
        return newPath.toFile().delete();
    }
}
