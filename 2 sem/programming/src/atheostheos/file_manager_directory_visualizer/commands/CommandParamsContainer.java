package atheostheos.file_manager_directory_visualizer.commands;

import java.util.ArrayList;

public interface CommandParamsContainer {

    void processParameters(String line);
    String getCommand();
    ArrayList<String> getArgs();
    ArrayList<String> getFlags();
}
