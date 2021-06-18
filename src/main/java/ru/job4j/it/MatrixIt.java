package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (data.length == 0 || data[row].length == 0 && row + 1 > data.length - 1) {
            return false;
        }
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        while (data[row].length == 0) {
            row++;
            if (row >= data.length) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}