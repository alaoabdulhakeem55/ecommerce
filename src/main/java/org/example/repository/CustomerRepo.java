package org.example.repository;

import org.example.model.Customer;

public interface CustomerRepo extends GenericRepo<Customer> {
   Customer findByEmail(String email);
}
