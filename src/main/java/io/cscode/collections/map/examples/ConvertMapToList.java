package io.cscode.collections.map.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {

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

    public static void convertMapValuesToList() {
        Map<Integer, Employee> employeesMap = Map.of(100, new Employee("Employee A",  "IT Support"),
                101, new Employee("Employee B",  "IT Support"),
                200, new Employee("Employee C",  "Logistics"),
                300, new Employee("Employee D",  "Administration"),
                400, new Employee("Employee E",  "Cyber Security")
        );
        List<String> employeeNames = employeesMap.values().stream().map(employee -> employee.name).collect(Collectors.toList());
        System.out.println(employeeNames);
    }

    public static void convertMapValuesToListAndFilter() {
        Map<Integer, Employee> employeesMap = Map.of(100, new Employee("Employee A",  "IT Support"),
                101, new Employee("Employee B",  "IT Support"),
                200, new Employee("Employee C",  "Logistics"),
                300, new Employee("Employee D",  "Administration"),
                400, new Employee("Employee E",  "Cyber Security")
        );
        List<String> employeeNames = employeesMap.values().stream()
                        .filter(employee -> "IT Support".equals(employee.department))
                        .map(employee -> employee.name).collect(Collectors.toList());
        System.out.println(employeeNames);
    }

    public static void convertMapKeySetToList() {
        Map<Integer, Employee> employeesMap = Map.of(100, new Employee("Employee A",  "IT Support"),
                101, new Employee("Employee B",  "IT Support"),
                200, new Employee("Employee C",  "Logistics"),
                300, new Employee("Employee D",  "Administration"),
                400, new Employee("Employee E",  "Cyber Security")
        );
        List<Integer> employeeIds = employeesMap.keySet().stream().collect(Collectors.toList());
        System.out.println(employeeIds);
    }

    public static void convertMapEntrySetToList() {
        Map<Integer, Employee> employeesMap = Map.of(100, new Employee("Employee A",  "IT Support"),
                101, new Employee("Employee B",  "IT Support"),
                200, new Employee("Employee C",  "Logistics"),
                300, new Employee("Employee D",  "Administration"),
                400, new Employee("Employee E",  "Cyber Security")
        );
        List<Employee> employees = employeesMap.entrySet().stream().filter(entry->entry.getKey()>=100 && entry.getKey()<=199)
                .map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(employees);
    }

    public static void main(String[] args) {
        //convertMapValuesToList();
        //convertMapValuesToListAndFilter();
        //convertMapKeySetToList();
        convertMapEntrySetToList();
    }
}
