import atheostheos.uri_container.URIContainer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        URIContainer cont = new URIContainer("ma'ddddilto://java-net@newstuffjava.sun.com:4212.4252/su/gramgnet");
        System.out.println(Arrays.toString(cont.getUriParts()));
        System.out.println(cont);
    }
}
