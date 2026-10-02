import java.util.*;

class Vehicle {
    String name;
    double pricePerDay;
    boolean available = true;

    Vehicle(String name, double pricePerDay) {
        this.name = name;
        this.pricePerDay = pricePerDay;
    }

    double calculateCharge(int days) {
        return pricePerDay * days;
    }
}

class Sedan extends Vehicle {
    Sedan(String name, double pricePerDay) {
        super(name, pricePerDay);
    }
}

class SUV extends Vehicle {
    SUV(String name, double pricePerDay) {
        super(name, pricePerDay);
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }
}

public class Que1 {
    public static void main(String[] args) {

        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A", 50);
        Vehicle suvB = new SUV("SUV B", 80);

        // Customer 1 rents Sedan A
        if (sedanA.available) {
            new Rental(sedanA, c1, 3);
            sedanA.available = false;

            System.out.println("Sedan A rented successfully by Customer 1.");
            System.out.println("Rental charge: $" + sedanA.calculateCharge(3));
        }

        // Customer 2 tries the same vehicle
        if (!sedanA.available) {
            System.out.println("Sedan A is currently unavailable.");
        }

        // Customer 1 returns the vehicle
        sedanA.available = true;
        System.out.println("Sedan A returned by Customer 1.");

        // Customer 3 rents SUV B
        if (suvB.available) {
            new Rental(suvB, c3, 5);
            suvB.available = false;

            System.out.println("SUV B rented successfully by Customer 3.");
            System.out.println("Rental charge: $" + suvB.calculateCharge(5));
        }
    }
}
