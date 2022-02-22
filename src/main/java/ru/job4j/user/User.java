package ru.job4j.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    static class Calendaric {
        final int months = 12;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1999, Calendar.MARCH, 25);
        User first = new User("Bob", 3, calendar);
        User second = new User("Bob", 3, calendar);
        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(first, new Object());
        userObjectMap.put(second, new Object());
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());

        for (var entry : userObjectMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println(".....part 2.....");
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR);
        int minute  = cal.get(Calendar.MINUTE);
        int seconds  = cal.get(Calendar.SECOND);
        int dayOfWeek   = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println("year is " + year);
        System.out.println("month is " + month);
        System.out.println("day is " + day);
        System.out.println("hour is " + hour);
        System.out.println("minute is " + minute);
        System.out.println("second is " + seconds);
        System.out.println("dayOfWeek is " + dayOfWeek);

        System.out.println(".....part 3.....");

        LocalDate localDate = LocalDate.now();
        LocalDateTime time = LocalDateTime.now();
        year = localDate.getYear();
        month = localDate.getMonth().getValue();
        day = localDate.getDayOfMonth();
        hour = time.getHour();
        minute = time.getMinute();
        seconds = time.getSecond();
        dayOfWeek = localDate.getDayOfWeek().getValue();

        System.out.println("year is " + year);
        System.out.println("month is " + month);
        System.out.println("day is " + day);
        System.out.println("hour is " + hour);
        System.out.println("minute is " + minute);
        System.out.println("second is " + seconds);
        System.out.println("dayOfWeek is " + dayOfWeek);

        System.out.println(".....part 4.....");

        Calendaric calendaric = new Calendaric();
        int months = calendaric.months;
        System.out.println("months is " + months);
    }
}