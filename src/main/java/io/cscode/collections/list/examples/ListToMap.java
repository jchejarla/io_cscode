package io.cscode.collections.list.examples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMap {

    static class Person {
        private String name;
        private int age;
        private String gender;

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "[name : " +name + " , age : "+age + ", gender : "+gender+"]";
        }
    }


    public static void listToMap(){
        List<Person> persons = List.of(
                new Person("Person A", 29, "Male"),
                new Person("Person B", 32, "Female"),
                new Person("Person C", 45, "Male"),
                new Person("Person D", 39, "Female")
        );

       Map<String, Person> nameToPersonMap= persons.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
       //to print each entry in a line, we are using iterator and print it
       nameToPersonMap.entrySet().iterator().forEachRemaining(System.out::println);

    }

    public static void listToMap_HandleDuplicates(){
        List<Person> persons = List.of(
                new Person("Person A", 29, "Male"),
                new Person("Person B", 32, "Female"),
                new Person("Person C", 45, "Male"),
                new Person("Person D", 39, "Female")
        );

        Map<String, List<Person>> nameToPersonMap= persons.stream().collect
                (Collectors.toMap(Person::getGender,
                        person-> {
                        List<Person> personList = new ArrayList<>();
                        personList.add(person);
                        return personList;
                    }, (oldValue, newValue) ->{
                            oldValue.addAll(newValue);
                            return oldValue;
                        }
                ));
        //to print each entry in a line, we are using iterator and print it
        nameToPersonMap.entrySet().iterator().forEachRemaining(System.out::println);

    }

    public static void listToMap_WithCustomMapImpl() {
        List<Person> persons = List.of(
                new Person("Person A", 29, "Male"),
                new Person("Person B", 32, "Female"),
                new Person("Person C", 45, "Male"),
                new Person("Person D", 39, "Female")
        );

        Map<String, Person> nameToPersonMap= persons.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity(),
                        (oldValue, newValue)->oldValue, LinkedHashMap::new ));
        //to print each entry in a line, we are using iterator and print it
        nameToPersonMap.entrySet().iterator().forEachRemaining(System.out::println);

    }

    public static void main(String[] args) {
        //listToMap();
        //listToMap_HandleDuplicates();
        //listToMap_WithCustomMapImpl();
    }
}
