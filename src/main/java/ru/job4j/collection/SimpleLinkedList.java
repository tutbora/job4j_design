package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public SimpleLinkedList() {
        last = new Node<>(null, null, null);
        first = new Node<>(null, null, last);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E value) {
            this.item = value;
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
    }

    @Override
    public void addLast(E value) {
        Node<E> temp = last;
        temp.setItem(value);
        last = new Node<>(null, temp, null);
        temp.setNext(last);
        size++;
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
        return new Iterator<>() {
            int count;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(count++);
            }
        };
    }
}