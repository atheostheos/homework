package atheostheos.parser;

import com.sun.javaws.IconUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser extends AbstractParser{
    String data;

    public FileParser(String pathString,Pattern pattern) throws IOException {
        Path path = Paths.get(pathString);
        List<String> dataList = Files.readAllLines(path);
        data = String.join("", dataList);
        matcher = pattern.matcher(data);
    }

}
