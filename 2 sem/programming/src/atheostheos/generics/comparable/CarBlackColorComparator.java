package atheostheos.generics.comparable;

import java.util.Comparator;

public class CarBlackColorComparator implements Comparator<Car> {


    public CarBlackColorComparator() {
    }

    @Override
    public int compare(Car c1, Car c2) {
        boolean isBlack1 = c1.getColor().equals("black");
        boolean isBlack2 = c2.getColor().equals("black");

        if (isBlack1 && isBlack2) {
            return 0;
        } else if (isBlack1) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
