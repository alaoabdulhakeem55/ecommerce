package org.example.service;

import org.example.enums.Gender;
import org.example.enums.Roles;
import org.example.model.Staff;

import java.util.List;

public interface StaffService {
    Staff hire(String name, int age, Gender gender, Roles role);
    Staff fire(String id);
    Object findAll();
    Staff findById(String id);

}
