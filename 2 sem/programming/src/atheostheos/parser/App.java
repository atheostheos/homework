package atheostheos.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\coalm\\OneDrive\\Документы\\git\\homework\\2 семестр\\programming\\data\\lamoda.txt";

        String itemsRegex = "<div class=\"products-list-item.*?</div></div></div>";
        Pattern itemsPattern = Pattern.compile(itemsRegex, Pattern.DOTALL);
        FileParser itemsParser = new FileParser(path, itemsPattern);
        ArrayList<String> items = itemsParser.getData(0);

        String priceRegex = "<span class=\"price\"><span class=\"price__actual\">(.*?)</span><span class=\"price__currency\">(.*?)</span>|" +
                "<span class=\"price__action js-cd-discount\">(.*?)</span><span class=\"price__currency\">(.*?)</span>";
        Pattern pricePattern = Pattern.compile(priceRegex, Pattern.DOTALL);
        ArrayParser priceParser = new ArrayParser(items, pricePattern);
        ArrayList<String> prices = priceParser.getData(1,2,3,4);

        String hrefRegex = "<a\\s*href=\".*?view-source:(.*?)>\".*?class=\"products-list-item__link";
        Pattern hrefPattern = Pattern.compile(hrefRegex, Pattern.DOTALL);
        ArrayParser hrefParser = new ArrayParser(items, hrefPattern);
        ArrayList<String> hrefs = hrefParser.getData(1);

        String nameRegex = "<img\\s*class=\"products-list-item__img\".*?alt=\"(.*?)\"";
        Pattern namePattern = Pattern.compile(nameRegex, Pattern.DOTALL);
        ArrayParser nameParser = new ArrayParser(items, namePattern);
        ArrayList<String> names = nameParser.getData(1);


        ArrayList<String[]> products = new ArrayList<>();

        for (int i=0 ; i< items.size(); i++) {
            String[] product = {names.get(i), prices.get(i), hrefs.get(i)};
            products.add(product);

            for(String elem: product) {
                System.out.print(elem + " ");
            }
            System.out.print('\n');
        }
    }
}
