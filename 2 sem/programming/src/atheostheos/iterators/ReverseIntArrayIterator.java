package atheostheos.iterators;

import java.util.Iterator;

public class ReverseIntArrayIterator implements Iterator<Integer> {
    private Integer[] a;
    private int cur;

    public ReverseIntArrayIterator(Integer[] a) {
        this.a = a;
        this.cur = a.length - 1;
    }

    @Override
    public boolean hasNext() {
        return (cur > -1);
    }

    @Override
    public Integer next() {
        if (cur < 0) throw new IllegalArgumentException();
        return a[cur--];

    }
}
