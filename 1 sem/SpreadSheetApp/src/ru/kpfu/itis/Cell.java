package ru.kpfu.itis;

public class Cell {
    protected String value;

    public Cell() {
        this.value = " ";
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isDouble() {
        boolean isDouble = true;
        try {
            Double.parseDouble(value);
        }
        catch (Exception e) {
            isDouble = false;
        }
        return isDouble;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if ((value.equals(null)) || (value.length() == 0)) this.value = " ";
        this.value = value;
    }

}
