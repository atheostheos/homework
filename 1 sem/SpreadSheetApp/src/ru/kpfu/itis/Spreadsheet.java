package ru.kpfu.itis;

import java.util.Arrays;
import java.util.Objects;

public class Spreadsheet {
    public final int SIZE;
    public Cell[][] cells;
    public int[] cellIndex;
    public Cell cell;

    public Spreadsheet(int size) {
        cells = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
        SIZE = size;
        cellIndex = new int[]{0, 0};
        cell = cells[0][0];
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spreadsheet)) return false;
        Spreadsheet that = (Spreadsheet) o;
        return SIZE == that.SIZE &&
                Arrays.equals(cells, that.cells);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(SIZE);
        result = 31 * result + Arrays.hashCode(cells);
        return result;
    }

    public void show() {
        int[] maxCellLength = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (maxCellLength[i] < cells[j][i].value.length()) {
                    maxCellLength[i] = cells[j][i].value.length();
                }
            }
        }

        System.out.printf("%3s ","");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%" + (maxCellLength[i]+1) + "d", (i + 1));
            System.out.print(" ");
        }
        System.out.print("\n");

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2s ",(i+1));
        for (int j = 0; j < SIZE; j++) {
            if (i == cellIndex[0] && j == cellIndex[1]) {
                System.out.printf("[%"+(maxCellLength[j])+"s ",cells[i][j]);
            } else {
                System.out.printf("|%" + (maxCellLength[j]) + "s ", cells[i][j]);
            }
        }
        System.out.print('\n');
        }
    }

    public void setCellIndex(int x, int y) {
        if ((x > SIZE) || (y > SIZE) ||
                (x < 0) || (y < 0)) {
            cellIndex = new int[]{0, 0};
        } else {
            cellIndex = new int[]{x-1, y-1};
            cell = this.cells[x-1][y-1];
        }
    }
}
