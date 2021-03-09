package atheostheos.iterators;

import java.util.Iterator;

public class OddIntArrayIterator implements Iterator<Integer> {
    private Integer[] a;
    private int cur;

    public OddIntArrayIterator(Integer[] a) {
        this.a = a;
    }

    @Override
    public boolean hasNext() {
        for (int i = cur+1; i < a.length; i++) {
            if (a[i] % 2 == 1) return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        while (cur < a.length) {
            if (a[cur] % 2 == 1) return a[cur++];
            cur++;
        }
        throw new IllegalStateException();
    }
}
