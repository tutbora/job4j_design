package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int indexHasNext = 0;
    private int indexNext = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (indexHasNext < data.length) {
            if (data[indexHasNext] % 2 == 0 && data[indexHasNext] != 0) {
                return true;
            }
            indexHasNext++;
        }
        return indexHasNext < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (indexHasNext < data.length) {
            if (data[indexNext] % 2 == 0 && data[indexNext] != 0) {
                indexHasNext++;
                return data[indexNext++];
            }
            indexNext++;
        }
        return data[indexHasNext++];
    }
}
