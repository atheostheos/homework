import java.util.Arrays;

public class Office {

    public static void main(String[] args) {

        VendingMachine snm = new VendingMachine();
        String[] items = {"Lays", "Doritos", "Skittles", "Bounty"};
        int[] itemsAmount = {0, 5, 2, 1};
        snm.items = items;
        snm.itemsAmount = itemsAmount;
        snm.itemsCost = 300.0f;
        snm.balance = 0.0f;
        snm.corpName = "Global Gum inc";

        snm.showItems();
        snm.buy("Chicken");
        snm.buy("Lays");
        snm.buy("Doritos");
        snm.addCash(500.0f);
        snm.buy("Bounty");
        snm.addCash(100.0f);
        snm.buy("Doritos");
        snm.showItems();

    }
}
