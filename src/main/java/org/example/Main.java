package org.example;

import org.example.controller.*;
import org.example.enums.Gender;
import org.example.enums.Roles;
import org.example.model.*;
import org.example.repository.CartRepo;
import org.example.repository.CheckoutRepo;
import org.example.repository.ProductRepo;
import org.example.repository.implementation.list.CartRepoImplList;
import org.example.repository.implementation.map.CheckoutRepoImplMap;
import org.example.repository.implementation.map.ProductRepoImplMap;
import org.example.response.APIResponse;
import org.example.service.CartService;
import org.example.service.CheckoutService;
import org.example.service.implementation.CartServiceImpl;
import org.example.service.implementation.CheckoutServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StaffController staffController= new StaffController();
        APIResponse<Staff> response = staffController.hire("John", 33, Gender.MALE, Roles.CASHIER);
        APIResponse<Staff> response1 = staffController.hire("Stephen", 26, Gender.MALE, Roles.CASHIER);
        APIResponse<Staff> response4 = staffController.hire("Alice", 26, Gender.FEMALE, Roles.CASHIER);
        APIResponse<Staff> response38 = staffController.hire("Johnson", 45, Gender.MALE, Roles.MANAGER);
        System.out.println(response);
        System.out.println(response1);
        System.out.println(response4);
        System.out.println(response38);

        APIResponse<Staff> response2 = staffController.fire("STAFF_2");
        System.out.println(response2);

        APIResponse<Object> response3 = staffController.findAll();
        System.out.println(response3);

        APIResponse<Staff> response5 = staffController.findById("STAFF_1");
        System.out.println(response5);
        APIResponse<Staff> response6 = staffController.findById("STAFF_2");
        System.out.println(response6);
        APIResponse<Staff> response7 = staffController.findById("STAFF_3");
        System.out.println(response7);

        System.out.println("***********************************************************");

        CustomerController customerController = new CustomerController();
        APIResponse<Customer> response8 = customerController.add("Joy", 15, Gender.FEMALE, "alao@yahoo.com");
        System.out.println(response8);
        APIResponse<Customer> response9 = customerController.add("Jane", 19, Gender.MALE, "akeem@yahoo.com");
        System.out.println(response9);
        APIResponse<Customer> response10 = customerController.add("Emmy", 20, Gender.MALE, "ade@yahoo.com");
        System.out.println(response10);

        APIResponse<Customer> response11 = customerController.remove("CUSTOMER_1");
        System.out.println(response11);

        APIResponse<Object> response12 = customerController.getAll();
        System.out.println(response12);

        APIResponse<Customer> response13 = customerController.findById("CUSTOMER_2");
        System.out.println(response13);

        APIResponse<Customer> response14 = customerController.findByEmail("akeem@yahoo.com");
        System.out.println(response14);
        APIResponse<Customer> response15 = customerController.findByEmail("ade@yahoo.com");
        System.out.println(response15);

        System.out.println("********************************************************************");

        ProductController productController = new ProductController();
        APIResponse<Product> response16 = productController.addToStore("Bread", 10.50, 10);
        System.out.println(response16);
        APIResponse<Product> response17 = productController.addToStore("Rice", 500.00, 5);
        System.out.println(response17);
        APIResponse<Product> response18 = productController.addToStore("Rice", 500.00, 4);
        System.out.println(response18);
        APIResponse<Product> response19 = productController.addToStore("Pen", 4.50, 15);
        System.out.println(response19);
        APIResponse<Product> response20 = productController.addToStore("Pen", 4.50, 15);
        System.out.println(response20);

//        APIResponse<Product> response21 = productController.removeFromStore("PRODUCT_1");
//        System.out.println(response21);

        APIResponse<Object> response22 = productController.getAll();
        System.out.println(response22);

        APIResponse<Product> response23 = productController.findById("PRODUCT_1");
        System.out.println(response23);
        APIResponse<Product> response24 = productController.findById("PRODUCT_2");
        System.out.println(response24);
        APIResponse<Product> response25 = productController.findById("PRODUCT_3");
        System.out.println(response25);

        System.out.println("**************************************************************");

        CartController cartController = new CartController();
        APIResponse<Cart> response26 = cartController.addToCart("PRODUCT_2", "CUSTOMER_1", 60);
        System.out.println(response26);
        APIResponse<Cart> response44 = cartController.addToCart("PRODUCT_3", "CUSTOMER_1", 8);
        APIResponse<Cart> response45 = cartController.addToCart("PRODUCT_1", "CUSTOMER_1", 10);

        APIResponse<Cart> response27 = cartController.reduceCartQuantity("PRODUCT_1", "CUSTOMER_1", 20);
        APIResponse<Cart> response46 = cartController.findByUserId("CUSTOMER_1");

        APIResponse<Object> response28 = cartController.getAll();
        System.out.println(response44);
        System.out.println(response45);
        System.out.println(response27);
        System.out.println(response28);
        System.out.println(response46);



        System.out.println("***********************************************************");

        CheckoutController checkoutController = new CheckoutController();

        APIResponse<Checkout> response30 = checkoutController.initiateCheckout(response46.data);
        System.out.println(response30);
        APIResponse<Checkout> response36 = checkoutController.finaliseCheckout(response30.data);
        System.out.println(response36);

        System.out.println("****************************************************");
        OrderController orderController = new OrderController();
        APIResponse<Object> response33 = orderController.retrieveUserOrder("CUSTOMER_1");
        System.out.println(response33);
        APIResponse<Object> response56 = productController.getAll();
        System.out.println(response56);
        System.out.println("****************************");
        APIResponse<Order> response32 = orderController.cancelOrder("ORDER_1");
        System.out.println(response32);
        APIResponse<Object> response39 = orderController.retrieveOrder("ORDER_1");
        System.out.println(response39);


        APIResponse<Object> response31 = orderController.retrieveUserOrder("CUSTOMER_1");
        System.out.println(response31);

        APIResponse<Object> response55 = productController.getAll();
        System.out.println(response55);
        System.out.println("**************************************");

        PaymentDetailsController paymentDetailsController = new PaymentDetailsController();
        APIResponse<PaymentDetails> response41 = paymentDetailsController.savePaymentDetails("445566777", "23/4/23", "234", 40.40);
        System.out.println(response41);
        APIResponse<PaymentDetails> response42 = paymentDetailsController.validatePaymentDetails(new PaymentDetails("1234", "445566777", "23/4/23", "234", 40.40));
        System.out.println(response42);


    }
}