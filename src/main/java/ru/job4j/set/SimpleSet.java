package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>();

    @Override
    public boolean add(T value) {
        boolean rsl = false;
        if (set.size() == 0) {
            set = new SimpleArrayList<>(10);
        }
        if (!contains(value)) {
            set.add(value);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> iterator = set.iterator();
        boolean rsl = false;
        while (iterator.hasNext()) {
            if (null == value || iterator.next().equals(value)) {
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