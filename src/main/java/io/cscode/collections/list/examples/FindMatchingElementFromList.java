package io.cscode.collections.list.examples;

import java.util.List;
import java.util.Optional;

public class FindMatchingElementFromList {

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

    public static void findFirstMatch() {
        List<Person> persons = List.of(
                new Person("Person A", 29),
                new Person("Person B", 32),
                new Person("Person C", 45),
                new Person("Person D", 39)
        );
        Optional<Person> firstMatch = persons.stream().
                filter(person -> person.getAge() >30).findFirst();
        if(firstMatch.isPresent()) {
            System.out.println("Person with match found : " + firstMatch.get());
        } else {
            System.out.println("No match found");
        }
    }

    public static void findAnyMatch() {
        List<Person> persons = List.of(
                new Person("Person A", 29),
                new Person("Person B", 32),
                new Person("Person C", 45),
                new Person("Person D", 39)
        );
        Optional<Person> firstMatch = persons.stream().
                filter(person -> person.getAge() >30).findAny();
        if(firstMatch.isPresent()) {
            System.out.println("Person with match found : " + firstMatch.get());
        } else {
            System.out.println("No match found");
        }
    }


    public static void main(String[] args) {
        //findFirstMatch();
        findAnyMatch();
    }
}
