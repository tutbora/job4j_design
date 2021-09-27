package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {
//    Node<E> head;
    private E[] containerLd;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    public SimpleLinkedList() {
    }

    public SimpleLinkedList(Collection<? extends E> col) {

    }

    @Override
    public void add(E value) {
/*        Node<E> node = new Node<>();
        node.data = value;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node<E> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        size++;*/
    }

    @Override
    public void addFirst(E value) {

    }

    @Override
    public void addLast(E value) {

    }

    @Override
    public E get(int index) {
/*        Objects.checkIndex(index, size);
        Node<E> node = head;
        while (node.next != null) {
            node = head;
        }
        return node.data;*/
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public void resize(int newLength) {
        this.containerLd = Arrays.copyOf(this.containerLd, newLength);
    }
}