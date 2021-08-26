package ru.job4j.it;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMap<T> implements Iterator<T> {
    private final Iterator<Iterator<T>> data;
    private Iterator<T> cursor = Collections.emptyIterator();
    
    public FlatMap(Iterator<Iterator<T>> data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (data.hasNext() && !cursor.hasNext()) {
            cursor = data.next();
        }
        return cursor.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public static void main(String[] args) {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(),
                List.of(7, 8, 9).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        while (flat.hasNext()) {
            System.out.println(flat.next());
        }

        List<List<Integer>> data2 = List.of(
                    List.of(1, 2, 3),
                    List.of(4, 5, 6),
                    List.of(7, 8, 9)
        );
        List<Integer> flat2 =
                data2.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        System.out.println(flat2);

        Collection<Integer> i1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collection<Integer> i2 = Arrays.asList(10, 20, 30, 40, 50);
        Collection<Integer> i3 = new ArrayList<>();
        Collection<Integer> i4 = Arrays.asList(100, 200, 300, 400);

        Collection<Collection<Integer>> iter = Arrays.asList(i1, i2, i3, i4);

        iter.forEach(col -> col.forEach(System.out::println));
    }
}