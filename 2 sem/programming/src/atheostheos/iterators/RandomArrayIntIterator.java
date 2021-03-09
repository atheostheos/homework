package atheostheos.iterators;

import java.util.Iterator;
import java.util.Random;

public class RandomArrayIntIterator implements Iterator<Integer> {
    private Integer[] a;
    private Random rand;

    public RandomArrayIntIterator(Integer[] a) {
        this.a = a;
        this.rand = new Random();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return a[rand.nextInt(a.length)];
    }
}
