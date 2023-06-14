package org.example.controller;

import org.example.enums.Gender;
import org.example.exceptions.AppException;
import org.example.exceptions.DBException;
import org.example.model.Customer;
import org.example.repository.CustomerRepo;
import org.example.repository.implementation.list.CustomerRepoImplList;
import org.example.repository.implementation.map.CustomerRepoImplMap;
import org.example.response.APIResponse;
import org.example.service.CustomerService;
import org.example.service.implementation.CustomerServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {

        this.customerService = new CustomerServiceImpl();
    }
    public APIResponse<Customer> add(String name, int age, Gender gender, String email) {
        Customer customer;
        try {
            customer = customerService.add(name, age, gender, email);
        } catch (AppException | DBException e){
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(customer, "customer successfully added", 200);
    }

    public APIResponse<Customer> remove(String id) {
        Customer customer;
        try {
            customer = customerService.remove(id) ;
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(customer, "customer has been removed", 200);
    }
    public APIResponse<Object> getAll() {
        Object customerList;
        try {
            customerList = customerService.getAll();
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(customerList, "List of all customers", 200);
    }

    public APIResponse<Customer> findById(String id) {
        Customer customer;
        try {
            customer = customerService.findById(id);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(customer, "customer found", 200);
    }

    public APIResponse<Customer> findByEmail(String email) {
        Customer customer;
        try {
            customer = customerService.findByEmail(email);
        } catch (AppException | DBException e) {
            return new APIResponse<>(null, e.getMessage(), 400);
        }
        return new APIResponse<>(customer, "customer found", 200);
    }
}
