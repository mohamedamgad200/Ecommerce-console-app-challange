package main;

import modal.Cart;
import modal.Customer;
import modal.product.Product;
import modal.product.ShippableExpirableProduct;
import modal.product.ShippableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Cart cart = new Cart();
            Customer customer = new Customer("Amgad", 5000, cart);

            ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 100, 10, 0.4, LocalDate.of(2025, 4, 30));
            ShippableProduct tv = new ShippableProduct("TV", 1000, 20, 0.7);
            Product scratchCard = new Product("Scratch Card", 200, 10);

            cart.addItem(cheese, 2);
            cart.addItem(tv, 2);
            cart.addItem(scratchCard, 1);

            customer.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
