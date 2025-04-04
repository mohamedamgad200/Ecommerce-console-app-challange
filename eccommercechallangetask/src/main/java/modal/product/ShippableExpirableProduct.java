package modal.product;

import java.time.LocalDate;

public class ShippableExpirableProduct extends Product implements ExpirableItem, ShippableItem{
    private double weight;
    private LocalDate expiryDate;
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public ShippableExpirableProduct(){}
    public ShippableExpirableProduct(String name, int price, int quantity, double weight,LocalDate expiryDate){
        super(name,price,quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    @Override
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
