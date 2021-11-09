package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> tListIterator = list.listIterator(index);
        if (tListIterator.nextIndex() == index) {
            tListIterator.add(value);
        }
        tListIterator.next();
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> tListIterator = list.listIterator(index);
        if (tListIterator.nextIndex() == index) {
            tListIterator.next();
            tListIterator.add(value);
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> tList = list.listIterator();
        ListIterator<T> tElements = elements.listIterator();
        while (tList.hasNext()) {
            if (tList.next().equals(tElements.next())) {
                tList.remove();
                tElements = elements.listIterator();
            } else if (!tElements.hasNext()) {
                tElements = elements.listIterator();
            } else {
                tList.previous();
            }
        }
    }
}