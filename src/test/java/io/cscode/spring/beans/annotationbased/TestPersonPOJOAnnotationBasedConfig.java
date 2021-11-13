package io.cscode.spring.beans.annotationbased;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestPersonPOJOAnnotationBasedConfig {

    @Test
    public void testPersonBean() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = applicationContext.getBean(Person.class);
        assertEquals("Cruise", person.getLastName());
    }
}
