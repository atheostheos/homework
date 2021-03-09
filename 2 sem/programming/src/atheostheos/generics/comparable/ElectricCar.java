package atheostheos.generics.comparable;

public class ElectricCar extends Car {
    private int batteryCapacity;

    public ElectricCar(int horsepower, String fuelType, String color, int batteryCapacity) {
        super(horsepower, fuelType, color);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
