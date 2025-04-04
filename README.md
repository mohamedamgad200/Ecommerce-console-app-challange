
# 🛒 E-Commerce System – Fawry N² Internship Challenge

## 📋 Overview

This project is a simulation of a simplified **e-commerce system** built in **Java**. It models key components of an online store, such as:
- Products (with or without expiration or shipping needs)
- A shopping cart
- Customers
- Checkout flow
- Shipping service

This system is designed to demonstrate **object-oriented programming principles** (inheritance, interfaces, polymorphism) and clean architectural thinking.

## 🎯 Features

✅ Define products with:
- `name`, `price`, and `quantity`

✅ Support different product behaviors:
- Some products **expire** (like cheese or biscuits)
- Some products **require shipping** (like TVs and cheese)
- Some products are **digital/non-shippable** (like scratch cards)

✅ Shopping Cart:
- Add products with a quantity ≤ available stock
- Prevent adding expired products
- Calculate **subtotal**
- Prevent checkout if:
  - Cart is empty
  - Customer has insufficient balance
  - Product is out of stock or expired

✅ Checkout Flow:
- Calculate and display:
  - Order subtotal
  - Shipping fees (flat rate)
  - Final amount paid
  - Customer’s remaining balance
- List all shippable items and send them to the `ShippingService`

✅ Shipping Service:
- Accepts a list of objects implementing the `ShippableItem` interface
- Displays:
  - Each item's quantity and weight
  - Total package weight

## 🔧 Tech Stack

- **Java 17+**
- Pure OOP, no frameworks
- Console-based simulation

## 🧱 Key Classes

| Class | Responsibility |
|-------|----------------|
| `Product` | Base class for all products |
| `ExpirableProduct` | Products that can expire |
| `ShippableProduct` | Products that require shipping |
| `ShippableExpirableProduct` | Products that expire **and** need shipping |
| `Cart` | Manages items added to the cart |
| `Customer` | Has a balance and can checkout |
| `ShippingService` | Handles shipment logic |
| `ShippableItem` | Interface for items that can be shipped |
| `ExpirableItem` | Interface for items that can expire |

## 🧪 Example

```java
ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 100, 10, 0.4, LocalDate.of(2025, 4, 30));
ShippableProduct tv = new ShippableProduct("TV", 1000, 20, 0.7);
Product scratchCard = new Product("Scratch Card", 200, 10);

cart.addItem(cheese, 2);
cart.addItem(tv, 1);
cart.addItem(scratchCard, 1);

customer.checkout(customer, cart);
```

### ✅ Sample Output:

```
** Shipment notice **
2x Cheese        400.0g
1x TV            700.0g
Total package weight 1.1kg

** Checkout Receipt **
2x Cheese        100
1x TV            1000
1x Scratch Card  200
-----------------------
Subtotal: 1400
Shipping Fee: 20
Total Amount: 1420
Remaining Balance: 3580
Checkout successful! 🎉
```

## 📦 How to Run

1. Clone the repo
2. Open the project in any Java IDE (e.g. IntelliJ, Eclipse)
3. Run the `Main.java` file

## ✍️ Author

**Mohamed Amgad** – Fawry Internship Challenge (N² Track)  
Faculty of Computers and Information – Ain Shams University
