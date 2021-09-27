package ru.job4j.collection;

public interface List<E> extends Iterable<E> {
    void add(E value);
    void addFirst(E value);
    void addLast(E value);
    E get(int index);
}