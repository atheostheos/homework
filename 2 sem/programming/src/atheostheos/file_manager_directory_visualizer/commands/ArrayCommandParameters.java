package atheostheos.file_manager_directory_visualizer.commands;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayCommandParameters implements CommandParameters {
    protected String command;
    protected ArrayList<String> args;
    protected ArrayList<String> flags;

    public ArrayCommandParameters(String line) {
        this.args = new ArrayList<>();
        this.flags = new ArrayList<>();
        Matcher commandMatcher = Pattern.compile("^[^\\s]+").matcher(line);
        Matcher argsMatcher = Pattern.compile(" ([^\\s\\-]+)").matcher(line);
        Matcher flagsMatcher = Pattern.compile("-([\\w]+)").matcher(line);

        commandMatcher.find();
        this.command = commandMatcher.group();

        while(argsMatcher.find()) {
            args.add(argsMatcher.group(1));
        }

        while(flagsMatcher.find()) {
            flags.add(flagsMatcher.group(1));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayCommandParameters)) return false;
        ArrayCommandParameters that = (ArrayCommandParameters) o;
        return Objects.equals(command, that.command) &&
                Objects.equals(args, that.args) &&
                Objects.equals(flags, that.flags);
    }

    @Override
    public String toString() {
        return command + args.toString() + flags.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, args, flags);
    }

    public String getCommand() {
        return command;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public ArrayList<String> getFlags() {
        return flags;
    }
}
