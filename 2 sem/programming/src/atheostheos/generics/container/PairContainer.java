package atheostheos.generics.container;

import java.util.Objects;

public class PairContainer<T1, T2> {
    private T1 first;
    private T2 second;

    public PairContainer(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairContainer)) return false;
        PairContainer<?, ?> that = (PairContainer<?, ?>) o;
        return first.equals(that.first) &&
                second.equals(that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "PairContainer{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
}
