package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        T temp;
        if (!out.isEmpty()) {
            temp = out.pop();
        } else {
            throw new NoSuchElementException();
        }
        return temp;
    }

    public void push(T value) {
        in.push(value);
    }
}