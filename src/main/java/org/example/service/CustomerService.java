package org.example.service;

import org.example.enums.Gender;
import org.example.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(String name, int age, Gender gender, String email);
    Customer remove(String id);
    Object getAll();
    Customer findById(String id);
    Customer findByEmail(String email);
}
