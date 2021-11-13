package io.cscode.spring.beans.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        try {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
            Person person = applicationContext.getBean(Person.class);
            System.out.println("First Name : " +person.getFirstName() + " , Last Name : " +person.getLastName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
