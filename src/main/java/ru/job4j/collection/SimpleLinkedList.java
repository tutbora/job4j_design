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
        last = new Node<>(null, null, null);
        first = new Node<>(null, null, last);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item, Node<E> prev, Node<E> next) {
            this.prev = prev;
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

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    @Override
    public void add(E value) {
    }

    @Override
    public void addFirst(E value) {
        Node<E> temp = first;
        temp.setItem(value);
        first = new Node<>(null, null, temp);
        temp.setPrev(first);
        size++;
        modCount++;
    }

    @Override
    public void addLast(E value) {
        Node<E> temp = last;
        temp.setItem(value);
        last = new Node<>(null, temp, null);
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
            private int indexIterator;

            @Override
            public boolean hasNext() {
                return indexIterator < size;
            }

            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                indexIterator++;
                if (indexIterator % 2 == 0) {
                    return getNext(first).getNext().getItem();
                }
                return getItem(first).getNext().getItem();
            }
        };
    }
}