package io.cscode.spring.beans.xmlbased;

import io.cscode.base.UnitTestBase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestPersonPOJOXMLBasedConfig extends UnitTestBase {

    @Test
    public void testPersonBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = applicationContext.getBean("tom", Person.class);
        applicationContext.close();
        assertEquals("Cruise", person.getLastName());
    }

}
