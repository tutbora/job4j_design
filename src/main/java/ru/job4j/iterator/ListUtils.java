package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            if (tListIterator.nextIndex() == index) {
                tListIterator.add(value);
                break;
            }
            tListIterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            if (tListIterator.nextIndex() == index) {
                tListIterator.next();
                tListIterator.add(value);
                tListIterator.previous();
                break;
            }
            tListIterator.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> tListIterator = list.listIterator();
        if (tListIterator.hasNext()) {
            do {
                if (filter.test(tListIterator.next())) {
                    tListIterator.remove();
                }
            } while (tListIterator.hasNext());
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> tListIterator = list.listIterator();
        if (tListIterator.hasNext()) {
            do {
                if (filter.test(tListIterator.next())) {
                    tListIterator.set(value);
                }
            } while (tListIterator.hasNext());
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> tListIterator = list.listIterator();
        while (tListIterator.hasNext()) {
            ListIterator<T> iterator = elements.listIterator();
            T elementList = tListIterator.next();
            while (iterator.hasNext()) {
                T elementElements = iterator.next();
                if (elementList.equals(elementElements)) {
                    tListIterator.remove();
                    break;
                }
            }
        }
    }
}