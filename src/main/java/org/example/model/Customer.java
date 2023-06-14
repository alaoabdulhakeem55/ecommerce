package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer extends Person implements Identifiable {
    private String email;

    public Customer(String id, String name, int age, String gender, String email) {
        super(id, name, age, gender);
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + super.getName()+ '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", id='" + super.getId()+ '\'' +
                ", email='" + this.email+ '\'' +
                '}';
    }
}