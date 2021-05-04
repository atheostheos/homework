package atheostheos.file_io_parctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryOperator {
    public static int readInt(FileInputStream fis) throws IOException {
        int result = 0;
        for (int i=24; i >= 0; i-=8) {
            int part = fis.read();
            result = result | (part<<i);
        }
        return result;
    }

    public static void putInt(FileOutputStream fos, int num) throws IOException{
        for (int i=24; i >= 0; i-=8) {
            fos.write(num>>i);
        }
        fos.flush();
    }
}
