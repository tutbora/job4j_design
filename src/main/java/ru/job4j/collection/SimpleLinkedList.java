package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
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

    private Node<E> getItem(Node<E> value) {
        return value;
    }

    @Override
    public Iterator<E> iterator() {
        int expectedModCount = modCount;

        return new Iterator<>() {
            private int countIterator;
            Node<E> linkItem;

            @Override
            public boolean hasNext() {
                return countIterator < size || linkItem.item == null;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                countIterator++;
                linkItem = first;
                linkItem.item = linkItem.next.item;
                linkItem.next = linkItem.next.next;
                return linkItem.item;
            }
        };
    }
}