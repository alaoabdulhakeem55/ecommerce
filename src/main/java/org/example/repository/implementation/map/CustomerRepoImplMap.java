package org.example.repository.implementation.map;

import org.example.model.Customer;
import org.example.repository.CustomerRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.Map;
import java.util.Objects;


public class CustomerRepoImplMap extends MapGenericRepo<Customer> implements CustomerRepo {
    public CustomerRepoImplMap(Map<String,Customer> map) {
        super(map, "CUSTOMER");
    }


    @Override
    public Customer findByEmail(String email) {
        for(Customer customer : getList().values()) {
            if(Objects.equals(customer.getEmail(), email)) {
               return customer;
            }
        }
        return null;
    }
}
