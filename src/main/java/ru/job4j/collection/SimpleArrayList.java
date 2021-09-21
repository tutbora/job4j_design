package ru.job4j.collection;

import ru.job4j.list.List;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    private int expectedModCount, indexIterator;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == this.container.length - 1) {
            resize(this.container.length * 2);
        }
        expectedModCount++;
        this.container[size++] = value;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        var oldElement = this.container[index];
        this.container[index] = newValue;
        expectedModCount++;
        return oldElement;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size--);
        var oldElement = this.container[index];
        if (size <= this.container.length / 3) {
            var array = (T[]) new Object[this.container.length / 2];
            System.arraycopy(this.container, 0,
                    array, 0, index);
            System.arraycopy(this.container, index + 1,
                    array, index, size - index);
            this.container = array;
        } else {
            System.arraycopy(this.container, index + 1,
                    this.container, index, size - index);
            this.container[size] = null;
        }
//        System.arraycopy(this.container, index + 1,
//                this.container, index, size - index - 1);
//        this.container[--size] = null;
//        if (size <= container.length / 3) {
//            resize(this.container.length / 2);
//        }
        expectedModCount++;
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
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
//                if (modCount != expectedModCount) {
//                    throw new ConcurrentModificationException("in the hasNext");
//                }
                if (expectedModCount > modCount) {
                    expectedModCount = modCount;
                }
                if (modCount == expectedModCount) {
                    modCount = 0;
                }
//                    expectedModCount++;
                if (modCount < size && container[modCount] != null) {
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount++) {
                    throw new ConcurrentModificationException("in the next");
                }
                return container[indexIterator++];
            }
        };
    }

    private void resize(int newLength) {
        var array = (T[]) new Object[newLength];
        System.arraycopy(this.container, 0,
                array, 0, size);
        this.container = array;
    }
}