package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    private int indexHasNext = 0;
    private int indexNext = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        while (indexHasNext < numbers.length) {
            if (numbers[indexHasNext] % 2 == 0 && numbers[indexHasNext] != 0) {
                return true;
            }
            indexHasNext++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[indexHasNext++];
    }
}
