package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private final SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean rsl = false;
        if (!contains(value)) {
            set.add(value);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        boolean rsl = false;
        for (T element : set) {
            if (null == value || element.equals(value)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}