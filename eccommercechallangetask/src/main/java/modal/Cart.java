package modal;

import modal.product.ExpirableProduct;
import modal.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> items;
    public Cart() {
        items = new HashMap<Product,Integer>();
    }
    public double getSubtotal () {
        double subtotal  = 0;
        for(Map.Entry<Product,Integer> entry : items.entrySet())
        {
            subtotal  += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal ;
    }
    public void addItem(Product product, int quantity) {
        if(product.getQuantity() < quantity)
        {
            throw  new IllegalArgumentException("product is out of stock");
        }
        items.put(product, quantity);
    }
    public void addItem(ExpirableProduct product, int quantity) {
        if(product.getQuantity() < quantity)
        {
            throw  new IllegalArgumentException("product is out of stock");
        }
        if(product.isExpired()){
            throw  new IllegalArgumentException("product is expired");
        }
        items.put(product, quantity);
    }
    public Map<Product, Integer> getItems() {
        return items;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void clearCart()
    {
        items.clear();
    }
    public void printCart()
    {
        for(Map.Entry<Product,Integer> entry : items.entrySet())
        {
            System.out.println(entry.getKey().getQuantity()+" X "+entry.getKey().getName()+" "+entry.getKey().getPrice());
        }
    }
}
