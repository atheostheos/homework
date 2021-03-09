package atheostheos.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Data {
    List<String> data;

    public Data(String pathString) throws IOException {
        Path path = Paths.get(pathString);
        data = Files.readAllLines(path);
    }
}
