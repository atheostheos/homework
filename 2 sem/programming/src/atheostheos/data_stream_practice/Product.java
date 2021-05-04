package atheostheos.data_stream_practice;

import java.util.Objects;

public class Product {
    protected String name;
    protected double price;
    protected int amount;

    public Product(String name, double price, int amount) {
        setName(name);
        setPrice(price);
        setAmount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name == product.name &&
                Double.compare(product.price, price) == 0 &&
                amount == product.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amount);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + name +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 5) {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
