package io.cscode.support.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GenerateLargeDataset {

    private static final String COMMA = ",";
    private static final String PATH_TO_FILE = "/Users/jc/Documents/cscode-files/sample_dataset.csv";

    private static final List<String> EMP_TITLES = Arrays.asList("Associate Software Engineer","Software Engineer"
                            ,"Senior Software Engineer","Principal Software Engineer"
                            ,"Software Architect","Senior Software Architect","Full Stack Developer","Data Engineer"
                            ,"Senior Data Engineer", "Principal Data Engineer","Manager", "Senior Manager", "Network Engineer", "Senior Network Engineer"
                            ,"Front End Developer", "Database Administrator", "Senior Database Administrator");

    private static final List<List<String>> SKILLSET = Arrays.asList(List.of("C", "Java")
                                                        , List.of("C"), List.of("C#",".Net"), List.of("Java")
                                                        ,List.of("JavaScript", "React"), List.of("JavaScript","CSS"),List.of("SQL", "Oracle")
                                                        ,List.of("SAP"), List.of("Golang"), List.of("Java","Kafka"), List.of("Java", "Scala"));
    public static void main(String[] args) {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(PATH_TO_FILE))) {
            bufferedWriter.write("Emp ID, Employee Name, Title, Department, Tenure, Skill 1, Skill 2, Skill 3");
            Random random = new Random();
            random.setSeed(0);
            for (int i = 1; i <= 5000000; i++) {
                int titleIndex = random.nextInt(EMP_TITLES.size() - 1);
                int skillSetIndex = random.nextInt(SKILLSET.size() - 1);
                Employee employee = new Employee(i, "Employee " + i, EMP_TITLES.get(titleIndex), "Engineering", random.nextInt(20), SKILLSET.get(skillSetIndex));
                bufferedWriter.write(employee.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @AllArgsConstructor
    private static class Employee {
        private long id;
        private String employeeName;
        private String title;
        private String department;
        private float tenure;
        private List<String> skillSet;

        @Override
        public String toString() {
            return String.valueOf(id).concat(COMMA)
                    .concat(employeeName).concat(COMMA)
                    .concat(title).concat(COMMA)
                    .concat(department).concat(COMMA)
                    .concat(String.valueOf(tenure)).concat(COMMA)
                    .concat(String.join(COMMA, skillSet));
        }
    }
}
