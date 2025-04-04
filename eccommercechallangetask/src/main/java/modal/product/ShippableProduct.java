package modal.product;

public class ShippableProduct extends Product implements  ShippableItem{
    private double weight;
    public ShippableProduct() {}
    public ShippableProduct(String name, int price, int quantity, double weight) {
        super(name,price,quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
