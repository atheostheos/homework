package atheostheos.data_stream_practice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ProductFileInputStream extends InputStream {
    InputStream in;

    public ProductFileInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductFileInputStream)) return false;
        ProductFileInputStream that = (ProductFileInputStream) o;
        return Objects.equals(in, that.in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(in);
    }

    public Product readProduct() throws IOException {
        
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return in.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return in.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return in.skip(n);
    }

    @Override
    public int available() throws IOException {
        return in.available();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    @Override
    public void mark(int readlimit) {
        in.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        in.reset();
    }

    @Override
    public boolean markSupported() {
        return in.markSupported();
    }
}
