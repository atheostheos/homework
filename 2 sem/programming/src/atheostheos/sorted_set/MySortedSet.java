package atheostheos.sorted_set;

import java.util.*;

public class MySortedSet<E> extends AbstractSet<E> implements SortedSet<E> {
    private int initial_capacity = 10;
    private final int INCREASE_COEF = 2;
    private int capacity = initial_capacity;
    private int size = 0;
    private E[] data;
    private Comparator<E> comparator;

    public MySortedSet(Comparator<E> comparator) {
        data = (E[]) new Object[initial_capacity];
        this.comparator = comparator;
    }

    public MySortedSet(Collection<? extends E> collection, Comparator<E> comparator) {
        this(comparator);
        addAll(collection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MySortedSet)) return false;
        MySortedSet<?> that = (MySortedSet<?>) o;
        return initial_capacity == that.initial_capacity &&
                capacity == that.capacity &&
                size == that.size &&
                Arrays.equals(data, Arrays.copyOf(this.data,size)) &&
                Objects.equals(comparator, that.comparator);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(initial_capacity, INCREASE_COEF, capacity, size, comparator);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i=0; i < size; i++) {
            str.append(data[i]);
            if (i < size -1) str.append(", ");
        }
        str.append("}");
        return str.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E el: data) {
            if (el != null)
                if (el.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new GenericArrayIterator();
    }

    protected class GenericArrayIterator implements Iterator<E> {
        private int index = 0;

        public GenericArrayIterator() { }

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public E next() {
            if (index >= size) throw new NoSuchElementException();
            return data[index++];
        }

        @Override
        public void remove() {
            if (index == 0) throw new NoSuchElementException();
            MySortedSet.this.remove(index-1);
            index--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] dataCopy = new Object[size];
        if (size >= 0) System.arraycopy(data, 0, dataCopy, 0, size);
        return dataCopy;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int count = 0;
        T[] containsMatrix = (T[]) new Object[a.length];
        for(int i=0; i<a.length; i++) {
            if (contains(a[i]))  {
                containsMatrix[i] = a[i];
                count++;
            }

        }
        T[] outAr = (T[]) new Object[count];
        int j = 0;
        for (T el: containsMatrix) {
            if (el != null) {
                outAr[j] = el;
                j++;
            }
        }
        return outAr;
    }

    @Override
    public boolean add(E e) {
        if (e == null) return false;
        if (size >= capacity) resize();
        if (!contains(e)) {
            data[size++] = e;
            Arrays.sort(data, 0, size, comparator);
            return true;
        }
        return false;
    }

    /*
    private void sort() {
        for (int i=0; i < size-1; i++) {
            for (int j=i; j<size; j++) {
                if (comparator.compare(data[i],data[j]) > 0) {
                    E temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
    */

    private void resize() {
        capacity *= INCREASE_COEF;
        E[] newData = (E[]) new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public boolean remove(Object o) {
        for (int i=0; i < size; i++) {
            if ((o == null && data[i] == null) || data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    private boolean remove(int index) {
        if ((index < 0) || (index >= size)) return false;

        if (index < (size-1)) {
            if (size - 1 - index >= 0) System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object el : c) {
            if (!contains(el)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for(E el: c) {
            add(el);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (E dataEl: data) {
            boolean delete = true;
            for (Object el: c)
                if (dataEl.equals(el)) {
                    delete = false;
                    break;
                }
            if(delete) remove(dataEl);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for(Object el: c) {
            if (contains(el)) remove(el);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Comparator<? super E> comparator() {
        return comparator;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        if (!contains(toElement) || !contains(fromElement)) throw new IllegalArgumentException();

        MySortedSet<E> set = new MySortedSet<E>(comparator);
        for (int i=indexOf(fromElement); i<=indexOf(toElement); i++) {
            set.add(data[i]);
        }
        return set;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        if (!contains(toElement)) throw new IllegalArgumentException();

        MySortedSet<E> set = new MySortedSet<E>(comparator);
        for (int i=0; i<=indexOf(toElement); i++) {
            set.add(data[i]);
        }
        return set;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        if (!contains(fromElement)) throw new IllegalArgumentException();

        MySortedSet<E> set = new MySortedSet<E>(comparator);
        for (int i=indexOf(fromElement); i<size; i++) {
            set.add(data[i]);
        }
        return set;
    }

    private int indexOf(E e) {
        for (int i=0; i< size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E first() {
        return data[0];
    }

    @Override
    public E last() {
        return data[size-1];
    }
}
