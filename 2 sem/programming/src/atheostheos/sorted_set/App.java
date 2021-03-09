package atheostheos.sorted_set;

import java.util.*;
import java.lang.Integer;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> col = new ArrayList<>();
        col.add(1);
        col.add(2);
        col.add(4);

        Random rand = new Random();
        MySortedSet<Integer> set = new MySortedSet<>(col, new MyComparator());
        for (int i=0; i < 9; i++) {
            set.add(rand.nextInt(8));
        }
        set.add(4);

        Integer[] ar = {3, 5 ,9};

        set.add(null);
        set.add(null);

        System.out.println(Arrays.toString(set.toArray(ar)));
        System.out.println(set);
        Iterator<Integer> iter = set.iterator();
        System.out.println(iter.next());
        iter.remove();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(set);
        /*System.out.println(set.headSet(3));
        System.out.println(set.tailSet(3));*/
        set.removeAll(col);
        System.out.println(set);
    }
}

class MyComparator implements Comparator<Integer> {

    MyComparator() {}

    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1 - o2);
    }
}
