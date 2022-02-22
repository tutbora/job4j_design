package ru.job4j.user;

import java.util.*;

public class User {
    private final String name;
    private final int children;
    private final Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String date = String.format("%04d.%02d.%02d%n",
                birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH) + 1,
                birthday.get(Calendar.DAY_OF_MONTH));
        return "Name:" + name
                + " Children:" + children
                + " Birthday:" + date;
    }

    @Override
    public boolean equals(Object anObject) {
        return this == anObject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1999, Calendar.MARCH, 25);
        User first = new User("Bob", 3, calendar);
        User second = new User("Bob", 3, calendar);
        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(first, new Object());
        userObjectMap.put(second, new Object());

        for (var entry : userObjectMap.entrySet()) {
            System.out.println(entry);
        }
    }
}