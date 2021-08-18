package ru.job4j.it;

import java.util.Iterator;

public class EvenIterator implements Iterator<Integer> {
    private final int[] numbers;
    Iterator<Integer> it = new EvenIterator(new int[]{4, 2, 1, 1});

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}
