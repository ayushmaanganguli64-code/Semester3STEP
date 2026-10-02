import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment...");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment...");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {

    public boolean processPayment(double amount) {
        System.out.println("Processing Bank Transfer...");
        return true;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Order {
    Customer customer;
    ArrayList<OrderItem> items = new ArrayList<>();
    String status = "Pending";

    Order(Customer customer) {
        this.customer = customer;
    }

    void addProduct(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    double getTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getTotal();
        }

        return total;
    }

    void pay(PaymentMethod payment) {

        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated for "
                + customer.name);

        boolean success = payment.processPayment(getTotal());

        if (success) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class Que5 {
    public static void main(String[] args) {

        Product productA = new Product("Product A", 100);
        Product productB = new Product("Product B", 200);
        Product productC = new Product("Product C", 300);

        // Customer X
        Customer x = new Customer("Customer X");
        Order orderX = new Order(x);

        orderX.addProduct(productA, 2);
        orderX.addProduct(productB, 1);

        System.out.println("Order created for Customer X.");
        orderX.pay(new CreditCardPayment());

        System.out.println();

        // Customer Y has an empty order
        Customer y = new Customer("Customer Y");
        Order orderY = new Order(y);

        orderY.pay(new CreditCardPayment());

        System.out.println();

        // Customer Z uses PayPal
        Customer z = new Customer("Customer Z");
        Order orderZ = new Order(z);

        orderZ.addProduct(productC, 1);

        orderZ.pay(new PayPalPayment());
    }
}
