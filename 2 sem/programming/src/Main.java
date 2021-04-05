import atheostheos.uri_container.URIContainer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        URIContainer cont1 = new URIContainer("ma'ddddilto://java-net@newstuffjava.sun.com:4212.4252/su/gramgnet");
        URIContainer cont2 = new URIContainer("/../ne.dd");
        URIContainer cont3 = new URIContainer("/trad/");

        System.out.println(Arrays.toString(cont1.getUriParts()));
        System.out.println(Arrays.toString(cont2.getUriParts()));
        System.out.println(Arrays.toString(cont3.getUriParts()));
        System.out.println(cont1);

    }
}
