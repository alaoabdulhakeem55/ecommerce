package org.example.repository.implementation.map;

import org.example.enums.OrderStatus;
import org.example.model.Order;
import org.example.repository.OrderRepo;

import java.util.*;


public class OrderRepoImplMap extends MapGenericRepo<Order> implements OrderRepo {
    public OrderRepoImplMap(Map<String, Order> map) {
        super(map, "Order");
    }

    @Override
    public Object getByUserId(String userId) {
        List<Order> userOrderList= new ArrayList<>();
        for(Order order : getList().values()) {
            if(Objects.equals(order.getUserId(), userId)) {
                if (order.getStatus() == OrderStatus.CHECKOUT || order.getStatus() == OrderStatus.DELIVERED) {
                    userOrderList.add(order);
                }

            }
        }
        return userOrderList;
    }
}
