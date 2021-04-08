package atheostheos.file_manager_directory_visualizer.commands;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractArrayCommandParamsContainer implements CommandParamsContainer {
    protected String command;
    protected ArrayList<String> args;
    protected ArrayList<String> flags;

    public AbstractArrayCommandParamsContainer(String line) {
        this.args = new ArrayList<String>();
        this.flags = new ArrayList<String>();
        processParameters(line);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegexCommandParamsContainer)) return false;
        RegexCommandParamsContainer that = (RegexCommandParamsContainer) o;
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
