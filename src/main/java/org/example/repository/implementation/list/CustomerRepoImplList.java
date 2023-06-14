package org.example.repository.implementation.list;

import org.example.model.Customer;
import org.example.repository.CustomerRepo;
import org.example.repository.implementation.map.MapGenericRepo;

import java.util.List;
import java.util.Map;
import java.util.Objects;


public class CustomerRepoImplList extends ListGenericRepo<Customer> implements CustomerRepo {
    public CustomerRepoImplList(List<Customer> list) {
        super(list, "customer");
    }


    @Override
    public Customer findByEmail(String email) {
        for(Customer customer : getList()) {
            if(Objects.equals(customer.getEmail(), email)) {
               return customer;
            }
        }
        return null;
    }
}
