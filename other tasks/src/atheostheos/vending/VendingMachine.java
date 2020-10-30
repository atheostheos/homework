public class VendingMachine {
    public String[] items;
    public int[] itemsAmount;
    public float itemsCost;
    public float balance;
    public String corpName;

    public void showItems() {
        for (String item: items) {
            System.out.print(item + " ");
        }
        System.out.printf("\nAll items cost: $%.2f.\n", itemsCost);
    }

    public boolean buy(String item) {
        System.out.printf("Getting item: %s.\n",item);
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == item) index = i;
        }
        if (index == -1) {
            System.out.println("Item not found.");
            return false;
        }
        if (itemsAmount[index] < 1) {
            System.out.println("Item is out of stock.");
            return false;
        }
        if ((balance - itemsCost) < 0) {
            System.out.println("Not enought cash.");
            return false;
        }
        itemsAmount[index] -= 1;
        balance -= itemsCost;
        System.out.printf("Item is ready to take. Thank you for choosing %s.\n", corpName);
        return true;
    }

    public void addCash(float cash) {
        balance += cash;
        System.out.printf("Added: $%.2f.\n", cash);
        this.showBalance();
    }
    public void showBalance() {
        System.out.printf("Current balance: $%.2f\n", balance);
    }

}
