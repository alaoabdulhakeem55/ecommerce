package org.example.repository;

import org.example.model.Order;

public interface OrderRepo extends GenericRepo<Order>{

    Object getByUserId(String userId);

}
