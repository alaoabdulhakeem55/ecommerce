package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends Base {
    private final String name;
    private int age;
    private final String gender;

    public Person(String id, String name, int age, String gender) {
        super(id);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
