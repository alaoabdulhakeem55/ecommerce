package org.example.service.implementation;

import org.example.enums.Gender;
import org.example.exceptions.AppException;
import org.example.model.Customer;
import org.example.repository.CustomerRepo;
import org.example.resources.Resources;
import org.example.service.CustomerService;

import java.util.List;
import java.util.Objects;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    // Constructor Dependency injection;
    public CustomerServiceImpl() {
        this.customerRepo = Resources.customerRepo;
    }


    @Override
    public Customer add(String name, int age, Gender gender, String email) {
        Customer customer = customerRepo.findByEmail(email);
        if(customer != null) {
            throw new AppException("Email already taken");

        }
            customer = new Customer("", name, age, gender.name(), email);
        return customerRepo.save(customer);
    }

    @Override
    public Customer remove(String id) {
        customerRepo.getById(id);
        return customerRepo.deleteById(id);
    }

    @Override
    public Object getAll() {
        return customerRepo.getList();
    }


    @Override
    public Customer findById(String id) {
        return customerRepo.getById(id);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }
}
