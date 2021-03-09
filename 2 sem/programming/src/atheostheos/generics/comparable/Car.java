package atheostheos.generics.comparable;

import java.util.Objects;

public abstract class Car implements Comparable<Car> {
    private int horsepower;
    private String fuelType;
    private String color;

    public Car(int horsepower, String fuelType, String color) {
        this.horsepower = horsepower;
        this.fuelType = fuelType;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return horsepower == car.horsepower &&
                Objects.equals(fuelType, car.fuelType) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsepower, fuelType, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "horsepower=" + horsepower +
                ", fuelType='" + fuelType + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car car) { //cars working on electricity are more preferable, if both electric compare horsepower
        if (this.fuelType.equals("electricity") && car.fuelType.equals("electricity")) {
            return (this.horsepower - car.horsepower);
        } else if (this.fuelType.equals("electricity")) {
            return 1;
        }
        return -1;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
