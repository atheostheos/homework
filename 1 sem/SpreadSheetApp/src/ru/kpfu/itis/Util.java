package ru.kpfu.itis;

public class Util {
    public static boolean isInArray(String str,String[] array) {
        boolean isInArray = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(str)) isInArray = true;
        }
        return isInArray;
    }

    public static void printLine(int length) {
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print("_");
        }
        System.out.print(" \n");
    }
}
