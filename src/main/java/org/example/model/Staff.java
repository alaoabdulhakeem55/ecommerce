package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Roles;

@Setter
@Getter
public class Staff extends Person implements Identifiable {
    private final String role;

    public Staff(String id, String name, int age, String gender, Roles role) {
        super(id, name, age, gender);
        this.role = String.valueOf(role);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + super.getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", id='" + super.getId() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}

