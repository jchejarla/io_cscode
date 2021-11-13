package io.cscode.spring.beans.annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Person createTomPerson() {
        return new Person("Tom", "Cruise");
    }

}
