package io.cscode.collections.map.examples;

import java.util.Map;

public class MapComputeIf {

    static class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return "[name : "+name + ", department : "+department+"]";
        }
    }

    public static void computeIfAbsentExample() {
        Map<Integer, ConvertMapToList.Employee> employeesMap = Map.of(100, new ConvertMapToList.Employee("Employee A",  "IT Support"),
                101, new ConvertMapToList.Employee("Employee B",  "IT Support"),
                200, new ConvertMapToList.Employee("Employee C",  "Logistics"),
                300, new ConvertMapToList.Employee("Employee D",  "Administration"),
                400, new ConvertMapToList.Employee("Employee E",  "Cyber Security")
        );
        //employeesMap.compute()
    }

    public static void main(String[] args) {

    }
}
