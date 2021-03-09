package ru.kpfu.itis;

public class Graph {
    protected String[][] coordinatePlane;
    protected int accuracy;

    public Graph(int accuracy) {
        int x = 10;
        int y = 20;
        coordinatePlane = new String[x][y];
        this.accuracy = accuracy;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                coordinatePlane[i][j] = " ";
            }
        }
    }

    public void build(Cell[] cellLine) {

    }

    public void show() {
        System.out.println("Graph: ");
        Util.printLine(coordinatePlane[0].length);
        for (int i = 0; i < coordinatePlane.length; i++) {
            String line = String.join("", coordinatePlane[i]);
            System.out.printf("|%s|\n",line);
        }
        Util.printLine(coordinatePlane[0].length);
    }
}
