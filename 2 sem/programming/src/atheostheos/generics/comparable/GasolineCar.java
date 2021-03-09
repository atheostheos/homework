package atheostheos.generics.comparable;

public class GasolineCar extends Car{
    private int fuelConsumption;
    private int fuelCapacity;
    private int fuelGrade;

    public GasolineCar(int horsepower, String fuelType, String color, int fuelConsumption, int fuelCapacity, int fuelGrade) {
        super(horsepower, fuelType, color);
        this.fuelConsumption = fuelConsumption;
        this.fuelCapacity = fuelCapacity;
        this.fuelGrade = fuelGrade;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getFuelGrade() {
        return fuelGrade;
    }
}
