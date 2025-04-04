package service;

import modal.product.ShippableItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<ShippableItem> items)
    {
        if(items.isEmpty())return;
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();

        for (ShippableItem item : items) {
            String name = item.getName();
            itemCount.put(name, itemCount.getOrDefault(name, 0) + 1);
            itemWeight.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : itemCount.keySet()) {
            System.out.println(itemCount.get(name) + "x " + name + " " + (itemWeight.get(name) * 1000) + "g");
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight);
    }
}
