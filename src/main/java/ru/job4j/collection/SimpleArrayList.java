package ru.job4j.collection;

import ru.job4j.list.List;
import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == this.container.length - 1) {
            resize(this.container.length * 2);
        }
        this.container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        var oldElement = this.container[index];
        this.container[index] = newValue;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        var oldElement = this.container[index];
        System.arraycopy(this.container, index + 1,
                this.container, index, size - index - 1);
        this.container[--size] = null;
        modCount++;
        return oldElement;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return this.container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<>() {

            private int indexIterator = 0;
            private int toBeginning = 0;

            @Override
            public boolean hasNext() {
                toBeginning++;
                if (toBeginning > 1) {
                    toBeginning = 2;
                }
                return indexIterator < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                toBeginning++;
                if (toBeginning == 2) {
                    indexIterator = 0;
                }
                toBeginning = 0;
                return container[indexIterator++];
            }
        };
    }

    public void resize(int newLength) {
        this.container = Arrays.copyOf(this.container, newLength);
    }
}