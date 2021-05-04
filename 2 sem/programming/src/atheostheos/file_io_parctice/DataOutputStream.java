package atheostheos.file_io_parctice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DataOutputStream extends OutputStream {
    FileOutputStream fos;

    public DataOutputStream(String name) throws FileNotFoundException {
        fos = new FileOutputStream(name);
    }

    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }

    public void writeInt(int num) throws IOException{
        for (int i=24; i >= 0; i-=8) {
            fos.write(num>>i);
        }
        fos.flush();
    }

    public void writeChar(char character) throws IOException{
        for (int i=16; i >= 0; i-=8) {
            fos.write(character>>i);
        }
        fos.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void close() throws IOException {
        fos.close();
    }
}
