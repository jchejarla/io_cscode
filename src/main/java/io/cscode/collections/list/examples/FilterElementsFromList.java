package io.cscode.collections.list.examples;

import java.util.List;
import java.util.stream.Collectors;

public class FilterElementsFromList {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "[name : " +name + " , age : "+age +"]";
        }
    }

    public static void filterListElementsUsingStream() {
        List<Person> persons = List.of(
                new Person("Person A", 29),
                new Person("Person B", 32),
                new Person("Person C", 45),
                new Person("Person D", 39)
        );
        System.out.println("BEFORE filtering : " + persons);
        List<Person> fruitsFiltered = persons.stream().
                filter(person -> person.getAge() >30 && person.getAge()<40)
                .collect(Collectors.toList());
        System.out.println("AFTER filter : " + fruitsFiltered);
    }


    public static void main(String[] args) {
        filterListElementsUsingStream();
    }
}
