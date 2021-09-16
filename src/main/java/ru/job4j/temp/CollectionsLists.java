package ru.job4j.temp;

import java.util.*;

public class CollectionsLists {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 1;
        list.add("one");
        list.add("two");
        list.add("three");
        print(list, i++);
        list.add(1, "four");
        print(list, i++);
        List<String> list1 = new ArrayList<>();
        list1.add("five");
        list1.add("six");
        list.addAll(list1);
        print(list, i++);
        List<String> list2 = new ArrayList<>();
        list2.add("seven");
        list2.add("eight");
        list.addAll(2, list2);
        print(list, i++);
        List<String> list3 = List.of("nine", "ten", "eleven");
        list.addAll(3, list3);
        printIterator(list, i++);
        list.replaceAll(String::toUpperCase);
        printIterator(list, i++);
        printIteratorPrev(list, i++);
        list.set(2, "seven by seven");
        print(list, i++);
        list.remove(5);
        list.remove("TEN");
        print(list, i++);
        List<String> list4 = List.of("qqq", "www", "eee");
        List<String> rsl = new ArrayList<>();
        list.addAll(list4);
        print(list, i++);
        list.removeAll(list4);
        print(list, i++);
        rsl.addAll(list);
        rsl.addAll(list4);
        print(rsl, i++);
        rsl.retainAll(list4);
        print(rsl, i++);
        list.removeIf(s -> s.length() > 5);
        print(list, i++);
        boolean b = list.contains("ONE");
        System.out.println("Contains: " + b);
        list.add("ONE");
        int indexFirst = list.indexOf("ONE");
        System.out.println("The index of first element on the list: " + indexFirst);
        int indexLast = list.lastIndexOf("ONE");
        System.out.println("The index of last element on the list: " + indexLast);
        indexFirst = list.indexOf("qqq");
        System.out.println("The element did not find: " + indexFirst);
        int size = list.size();
        System.out.println("Size of list is:" + size);
        list = list.subList(1, 8);
        for (String s : list) {
            System.out.println("Current element: " + s);
        }
        list.sort(Comparator.reverseOrder());
        i++;
        print(list, i);
    }

    public static void print(List<String> list, int i) {
        System.out.println("example № " + i);
        for (String s : list) {
            System.out.println("Current element: " + s);
        }
    }

    public static void printIterator(List<String> list, int i) {
        System.out.println("example № " + i);
        Iterator<String> iterator = list.listIterator(4);
        while (iterator.hasNext()) {
            System.out.println("Current element: " + iterator.next());
        }
    }

    public static void printIteratorPrev(List<String> list, int i) {
        System.out.println("example № " + i);
        ListIterator<String> listIterator = list.listIterator(6);
        while (listIterator.hasPrevious()) {
            System.out.println("Current element: " + listIterator.previous());
        }
    }
}
