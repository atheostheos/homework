package atheostheos.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParser extends AbstractParser {
    protected String data;

    public ArrayParser(ArrayList<String> data, Pattern pattern) {
        this.data = data.toString();
        this.matcher = pattern.matcher(this.data);
    }
}
