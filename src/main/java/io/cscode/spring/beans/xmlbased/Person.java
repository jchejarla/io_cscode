package io.cscode.spring.beans.xmlbased;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {
    String firstName;
    String lastName;

    public void customInit() {
        System.out.println("inside custom initialization");
    }

    public void customDestroy() {
        System.out.println("inside custom destroy");
    }
}
