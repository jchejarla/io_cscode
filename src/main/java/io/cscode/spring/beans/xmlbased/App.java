package io.cscode.spring.beans.xmlbased;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
            Person person = applicationContext.getBean("tom", Person.class);
            System.out.println("First Name : " +person.getFirstName() + " , Last Name : " +person.getLastName());
            applicationContext.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
