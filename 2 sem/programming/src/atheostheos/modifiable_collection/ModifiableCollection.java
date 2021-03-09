package atheostheos.modifiable_collection;

import java.util.AbstractCollection;
import java.util.Iterator;

public class ModifiableCollection<E> extends AbstractCollection<E> {
    private final int DEFAULT_CAPACITY = 4;
    private final int INCREASE_COEF = 2;
    private int capacity = 0;
    private int size = 0;
    private E[] data;

    ModifiableCollection() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
    }

    ModifiableCollection(E[] data) {
        this.data = (E[]) new Object[DEFAULT_CAPACITY];
        for (E el: data) {
            add(el);
        }
    }

    @Override
    public boolean add(E e) {
        if (size >= capacity) resize();
        data[size++] = e;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new CollectionIterator();
    }

    @Override
    public int size() {
        return this.size;
    }

    private void resize() {
        capacity *= INCREASE_COEF;
        E[] newData = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private class CollectionIterator implements Iterator<E> {
        private int index = 0;

        public CollectionIterator() {
        }

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public E next() {
            return data[index++];
        }

        @Override
        public void remove() {
            if (index >= size) throw new ArrayIndexOutOfBoundsException(); //~~~~~~~
            for(int i = index; i < size; i++) {
                data[i] = data[i+1];
            }
            index--;
            size--;
        }
    }
}
