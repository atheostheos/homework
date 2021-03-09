package atheostheos.parser;

import java.util.ArrayList;
import java.util.regex.Matcher;

public abstract class AbstractParser implements IParser {
    protected Matcher matcher;

    public ArrayList<String> getData(int...groups) {
        ArrayList<String> data = new ArrayList<>();
        String match;
        while (matcher.find()) {
            StringBuilder result = new StringBuilder();
            for(int group: groups) {
                match = matcher.group(group);
                if (match != null) result.append(match);
            }
            data.add(result.toString());
        }
        return data;
    }
}
