package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.next();
                i.add(value);
                i.previous();
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        T element;
        while (i.hasNext()) {
            element = i.next();
            if (filter.test(element)) {
                i.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        T element;
        while (i.hasNext()) {
            element = i.next();
            if (filter.test(element)) {
                i.set(value);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();
        T elementList;
        T elementElements;
        while (i.hasNext()) {
            ListIterator<T> ii = elements.listIterator();
            elementList = i.next();
            while (ii.hasNext()) {
                elementElements = ii.next();
                if (elementList.equals(elementElements)) {
                    i.remove();
                    break;
                }
            }
        }
    }
}