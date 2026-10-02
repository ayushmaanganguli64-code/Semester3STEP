import java.time.LocalDate;
import java.util.*;

abstract class Room {
    int roomNumber;
    double price;

    Room(int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    abstract double calculatePrice(long days);
}

class StandardRoom extends Room {

    StandardRoom(int roomNumber, double price) {
        super(roomNumber, price);
    }

    double calculatePrice(long days) {
        return price * days;
    }
}

class DeluxeRoom extends Room {

    DeluxeRoom(int roomNumber, double price) {
        super(roomNumber, price);
    }

    double calculatePrice(long days) {
        return price * days * 1.2;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    boolean cancelled = false;

    Reservation(Customer customer, Room room,
                LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    boolean overlaps(LocalDate start, LocalDate end) {
        return !end.isBefore(startDate) &&
               !start.isAfter(endDate);
    }

    void cancel() {
        if (!cancelled) {
            cancelled = true;
            System.out.println("Reservation cancelled successfully.");
        }
    }
}

class Hotel {
    ArrayList<Reservation> reservations = new ArrayList<>();

    boolean isAvailable(Room room, LocalDate start, LocalDate end) {

        for (Reservation r : reservations) {
            if (r.room == room && !r.cancelled &&
                    r.overlaps(start, end)) {
                return false;
            }
        }

        return true;
    }

    void book(Customer customer, Room room,
              LocalDate start, LocalDate end) {

        if (isAvailable(room, start, end)) {

            Reservation r =
                    new Reservation(customer, room, start, end);

            reservations.add(r);

            long days = java.time.temporal.ChronoUnit.DAYS
                    .between(start, end);

            // Minimum one day
            if (days == 0) {
                days = 1;
            }

            System.out.println("Reservation confirmed for "
                    + customer.name + ", Room " + room.roomNumber);

            System.out.println("Price: $"
                    + room.calculatePrice(days));

        } else {
            System.out.println("Room " + room.roomNumber
                    + " is not available for these dates.");
        }
    }
}

public class Que4 {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();

        Customer a = new Customer("Customer A");
        Customer c = new Customer("Customer C");

        Room standard = new StandardRoom(101, 100);
        Room deluxe = new DeluxeRoom(201, 150);

        LocalDate jan1 = LocalDate.of(2026, 1, 1);
        LocalDate jan5 = LocalDate.of(2026, 1, 5);

        // First booking
        hotel.book(a, standard, jan1, jan5);

        // Overlapping booking
        LocalDate jan3 = LocalDate.of(2026, 1, 3);
        LocalDate jan7 = LocalDate.of(2026, 1, 7);

        hotel.book(a, standard, jan3, jan7);

        // Cancel the first reservation
        hotel.reservations.get(0).cancel();

        // Now the room can be booked again
        LocalDate feb10 = LocalDate.of(2026, 2, 10);
        LocalDate feb12 = LocalDate.of(2026, 2, 12);

        hotel.book(c, deluxe, feb10, feb12);
    }
}
