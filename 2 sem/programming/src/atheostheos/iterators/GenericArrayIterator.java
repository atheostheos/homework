package atheostheos.iterators;

import java.util.Iterator;

public class GenericArrayIterator<E> implements Iterator<E> {
    private E[] a;
    private int cur;

    public GenericArrayIterator(E[] a) {
        this.a = a;
    }

    @Override
    public boolean hasNext() {
        return (cur < a.length);
    }

    @Override
    public E next() {
        if (cur >= a.length) throw new IllegalStateException();
        return a[cur++];
    }

}
