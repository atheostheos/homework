package atheostheos.data_stream_practice;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("bruhma", 234, 11);
        products[1] = new Product("boorma", 114, 111);
        products[2] = new Product("bertat", 994, 1111);

        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("data/products.data")
        )) {
            for(Product product:products) {
                dos.writeChars(product.getName());
                dos.writeDouble(product.getPrice());
                dos.writeInt(product.getAmount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("data/products.data")
        )) {
            Product[] out = new Product[3];
            for (int i = 0 ; i < 3; i++) {
                StringBuilder builder = new StringBuilder();
                for(int j = 0; j < 6; j++) {
                    builder.append(dis.readChar());
                }

                String name = builder.toString();
                double price = dis.readDouble();
                int amount = dis.readInt();
                out[i] = new Product(name,price,amount);
                System.out.println(out[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
