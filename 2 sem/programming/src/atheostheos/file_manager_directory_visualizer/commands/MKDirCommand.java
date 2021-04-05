package atheostheos.file_manager_directory_visualizer.commands;

import atheostheos.file_manager_directory_visualizer.FileManager;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MKDirCommand extends AbstractCommand{

    public MKDirCommand() {
        name = "mkdir";
    }

    @Override
    public String toString() {
        return String.format("%-10s Creates a new directory on the specified path.", name.toUpperCase());
    }

    @Override
    public boolean process(FileManager manager, CommandParameters params) {
        boolean result = false;
        Path goTo = Paths.get(params.getArgs().get(0));
        Path curPath = manager.getDirectory().toPath();
        Path newPath = curPath.resolve(goTo).normalize().toAbsolutePath();

        if (params.getFlags().contains("p")) {
            result = newPath.toFile().mkdirs();
        } else {
            result = newPath.toFile().mkdir();
        }

        if (result) System.out.println("New directory created");
        else System.out.println("Unable to create new directory");

        return result;
    }
}
