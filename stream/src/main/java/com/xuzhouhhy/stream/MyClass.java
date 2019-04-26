package com.xuzhouhhy.stream;

import java.util.ArrayList;

public class MyClass {

    int count() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(17));
        people.add(new Person(19));
        long count = people.stream()
                .filter(person -> person.age >= 19)
                .count();
        return Long.valueOf(count).intValue();
    }

    public static void main(String... args){
        new MyClass().count();
    }
}
