package atheostheos.uri_container;

import java.security.URIParameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URIContainer {
    protected final int GROUPS_AMOUNT = 8;
    protected final String REGEX = "^([^:]+):(?://)?(?:([^:]*):?([^@]*)@)?" +
                                    "([^:/]+):?([\\d.]*)/?([a-zа-яё%/]*)" +
                                    "\\??([a-zа-яё/=\"'&]*)#?(.*)$";
    protected String uri;
    protected String[] uriParts = new String[8];

    public URIContainer(String uri) {
        this.uri = uri;
        Matcher matcher = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE+Pattern.UNICODE_CASE+Pattern.MULTILINE).matcher(uri);
        try {
            matcher.find();
            for (int i = 1; i<=GROUPS_AMOUNT;i++) {
                uriParts[i-1] = matcher.group(i);
                if ((uriParts[i-1] != null) && (uriParts[i-1].equals(""))) uriParts[i-1] = null;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Incorrect uri format");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof URIContainer)) return false;
        URIContainer that = (URIContainer) o;
        return Objects.equals(uri, that.uri) &&
                Arrays.equals(uriParts, that.uriParts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uri);
        result = 31 * result + Arrays.hashCode(uriParts);
        return result;
    }

    @Override
    public String toString() {
        return uri;
    }

    public String[] getUriParts() {
        return uriParts.clone();
    }

    public String getSchema() {
        return uriParts[0];
    }

    public String getUser() {
        return uriParts[1];
    }

    public String getPassword() {
        return uriParts[2];
    }

    public String getHost() {
        return uriParts[3];
    }

    public String getPort() {
        return uriParts[4];
    }

    public String getPath() {
        return uriParts[5];
    }

    public String getQuery() {
        return uriParts[6];
    }

    public String getFragment() {
        return uriParts[7];
    }
}
