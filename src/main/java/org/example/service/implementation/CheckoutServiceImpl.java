package org.example.service.implementation;

import org.example.enums.CheckoutStatus;
import org.example.enums.OrderStatus;
import org.example.exceptions.AppException;
import org.example.model.Cart;
import org.example.model.Checkout;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.CheckoutRepo;
import org.example.repository.OrderRepo;
import org.example.repository.ProductRepo;
import org.example.resources.Resources;
import org.example.service.CheckoutService;


public class CheckoutServiceImpl implements CheckoutService {
    private final CheckoutRepo checkoutRepo;
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    // Constructor Dependency injection;
    public CheckoutServiceImpl() {
        this.checkoutRepo = Resources.checkoutRepo;
        this.productRepo = Resources.productRepo;
        this.orderRepo = Resources.orderRepo;
    }

    @Override
    public Checkout initiateCheckout(Cart cart) {

        Checkout checkout = new Checkout("", cart.getUserId());
        checkout.setUserId(cart.getUserId());

        double totalPrice = 0.0;

        for (Cart.Item item : cart.getItemList()) {
            Product product = productRepo.getById(item.getProductId());
            if (product == null) {
                throw new AppException("Product not found: " + item.getProductId());
            }

            if (item.getQuantity() > product.getQuantity()) {
                throw new AppException("Product out of stock: " + product.getName());
            }

            int newQuantity = product.getQuantity() - item.getQuantity();
            product.setQuantity(newQuantity);
            productRepo.save(product);

            double cost = product.getPrice() * item.getQuantity();
            totalPrice += cost;

            Order order = new Order("", cart.getUserId(), item.getProductId(), item.getQuantity(), cost);
            order = orderRepo.save(order);
            checkout.getListOfOrderId().add(order.getId());
        }

        checkout.setTotalPrice(totalPrice);
        checkout = checkoutRepo.save(checkout);
        return checkout;
    }

    public Checkout finaliseCheckout(Checkout checkout) {
        if(checkout.getTotalPrice() < 100) {
            throw new AppException("cannot make payment for checkout less than 100.");
        }
        for(String id : checkout.getListOfOrderId()) {
            Order order = orderRepo.getById(id);
            order.setStatus(OrderStatus.CHECKOUT);
            orderRepo.save(order);
        }
        checkout.setStatus(CheckoutStatus.PAID);
        return checkout;
    }
}
