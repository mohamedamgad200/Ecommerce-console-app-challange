package modal;

import modal.product.Product;
import modal.product.ShippableItem;
import service.ShippingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private double balance;
    private Cart cart;
    public Customer() {}
    public Customer(String name, double balance, Cart cart) {
        this.name = name;
        this.balance = balance;
        this.cart = cart;
    }
    public void checkout(Customer customer, Cart cart)
    {
        double shippingFee=20.0;
        double totalAmount;
        if (customer.getCart().isEmpty())
        {
            throw new IllegalArgumentException("Cart is empty ");
        }
        double subtotal=customer.getCart().getSubtotal();
        if(customer.getBalance()<subtotal)
        {
            throw new IllegalArgumentException("Customer's balance is insufficient");
        }
        List<ShippableItem> shippableItems = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            if (product instanceof ShippableItem) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add((ShippableItem) product);
                }
            }
        }
        ShippingService.ship(shippableItems);
        totalAmount=subtotal+shippingFee;
        customer.balance-=totalAmount;
        System.out.println("\n** Checkout Receipt **");
        customer.getCart().printCart();
        System.out.println("-----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping Fee: " + shippingFee);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Remaining Balance: " + balance);
        System.out.println("Checkout successful! 🎉\n");

        cart.clearCart();


    }
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }
}
