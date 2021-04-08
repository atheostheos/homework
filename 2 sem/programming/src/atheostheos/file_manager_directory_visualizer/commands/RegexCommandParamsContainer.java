package atheostheos.file_manager_directory_visualizer.commands;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCommandParamsContainer extends AbstractArrayCommandParamsContainer {

    public RegexCommandParamsContainer(String line) {
        super(line);
    }

    @Override
    public void processParameters(String line) {
        Matcher commandMatcher = Pattern.compile("^[^\\s]+").matcher(line);
        Matcher argsMatcher = Pattern.compile(" \"(.+)\"| ([^\\s\\-]+)").matcher(line);
        Matcher flagsMatcher = Pattern.compile("-([\\w]+)").matcher(line);

        if (commandMatcher.find()) this.command = commandMatcher.group();

        while(argsMatcher.find()) {
            args.add((argsMatcher.group(1) != null) ? argsMatcher.group(1): argsMatcher.group(2));
        }

        while(flagsMatcher.find()) {
            flags.add(flagsMatcher.group(1));
        }
    }
}
