package atheostheos.file_streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\coalm\\OneDrive\\Документы\\git\\homework\\2 sem\\programming\\data\\new.txt");
        try(FileInputStream fis = new FileInputStream(file)) {
            int a;
            while ((a = fis.read()) != -1) {
                System.out.println((char) a);
            }
        }

        FileOutputStream fis = new FileOutputStream(file,true);
        try {
            fis.write('b');
            fis.write(256);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
