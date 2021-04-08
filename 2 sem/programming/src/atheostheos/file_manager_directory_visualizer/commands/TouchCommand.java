package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TouchCommand extends AbstractCommand{

    public TouchCommand() {
        name = "touch";
    }

    @Override
    public String toString() {
        return String.format("%-10s Creates a new file or several new files.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParamsContainer params) {
        boolean allCreated = true;
        for (String filename: params.getArgs()) {
            Path filePath = Paths.get(filename);
            Path newPath = manager.getDirectory().toPath().resolve(filePath);

            try {
                allCreated &=newPath.toFile().createNewFile();
            } catch(IOException e) {
                allCreated = false;
            }
        }
        return allCreated;
    }
}
