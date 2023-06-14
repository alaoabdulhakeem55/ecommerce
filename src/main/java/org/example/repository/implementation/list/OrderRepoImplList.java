package org.example.repository.implementation.list;

import org.example.enums.OrderStatus;
import org.example.model.Order;
import org.example.repository.OrderRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderRepoImplList extends ListGenericRepo<Order> implements OrderRepo {
    public OrderRepoImplList(List<Order> list) {
        super(list, "Order");
    }

    @Override
    public Object getByUserId(String userId) {
        List<Order> userOrderList = new ArrayList<>();
        for(Order order : getList()) {
            if(Objects.equals(order.getUserId(), userId)) {
                if (order.getStatus() == OrderStatus.CHECKOUT || order.getStatus() == OrderStatus.DELIVERED) {
                    userOrderList.add(order);
                }

            }
        }
        return userOrderList;
    }
}
