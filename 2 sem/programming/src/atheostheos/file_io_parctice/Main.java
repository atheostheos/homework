package atheostheos.file_io_parctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        try(FileInputStream fis = new FileInputStream("data/trash/int");
            FileOutputStream fos = new FileOutputStream("data/trash/int", true)) {
            BinaryOperator.putInt(fos, 1002);
            int res;
            while ( (res = BinaryOperator.readInt(fis)) != -1) {
                System.out.println(res);
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
