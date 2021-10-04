package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private final Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;

    public SimpleLinkedList() {
        last = new Node<>(null, null);
        first = new Node<>(null, last);
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> temp = last;
        temp.setItem(value);
        last = new Node<>(null, temp);
        temp.setNext(last);
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> target = first.getNext();
        for (int i = 0; i < index; i++) {
            target = getNext(target);
        }
        return target.getItem();
    }

    private Node<E> getNext(Node<E> value) {
        return value.getNext();
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;

        return new Iterator<>() {
            // first это заглушка => первая нода со значением first.next;
            Node<E> linkItem = first.next;

            @Override
            public boolean hasNext() {
                // last заглушка => проверяем что не дошли до last
                return linkItem != last;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                // просто получаем значение
                // и делаем сдвиг
                E value = linkItem.item;
                linkItem = linkItem.next;
                return value;
            }
        };
    }
}