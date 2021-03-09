package atheostheos.generics.comparable;

import java.util.Comparator;

public class GasolineCarFuelGradeComparator implements Comparator<GasolineCar> {

    @Override
    public int compare(GasolineCar c1, GasolineCar c2) {
        return (c1.getFuelGrade() - c2.getFuelGrade());
    }
}
