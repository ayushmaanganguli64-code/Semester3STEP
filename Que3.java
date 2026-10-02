import java.util.*;

abstract class Seat {
    String seatNumber;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {

    RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {

    PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {

    ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    double getPrice() {
        return 400;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Show {
    String time;
    boolean started = false;

    // Keeps track of seats already booked
    ArrayList<Seat> bookedSeats = new ArrayList<>();

    Show(String time) {
        this.time = time;
    }

    boolean isAvailable(Seat seat) {
        return !bookedSeats.contains(seat);
    }

    void bookSeat(Seat seat) {
        bookedSeats.add(seat);
    }

    void releaseSeat(Seat seat) {
        bookedSeats.remove(seat);
    }
}

class Booking {
    Customer customer;
    Show show;
    ArrayList<Seat> seats = new ArrayList<>();
    boolean cancelled = false;

    Booking(Customer customer, Show show, Seat... selectedSeats) {

        if (selectedSeats.length > 6) {
            System.out.println("Maximum 6 seats can be booked.");
            return;
        }

        // Check all seats before booking
        for (Seat seat : selectedSeats) {
            if (!show.isAvailable(seat)) {
                System.out.println("Seat " + seat.seatNumber
                        + " is already booked for this show.");
                return;
            }
        }

        this.customer = customer;
        this.show = show;

        for (Seat seat : selectedSeats) {
            seats.add(seat);
            show.bookSeat(seat);
        }

        System.out.print("Booking confirmed for "
                + customer.name + ": ");

        for (Seat seat : seats) {
            System.out.print(seat.seatNumber + " ");
        }

        System.out.printf("%nTotal: ₹%.2f%n", getTotal());
    }

    double getTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    void cancel() {

        if (show.started) {
            System.out.println("Cannot cancel after the show has started.");
            return;
        }

        if (cancelled) {
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat);
        }

        cancelled = true;

        System.out.println(customer.name + "'s booking cancelled.");
        System.out.println("Seats released.");
    }
}

public class Que3 {
    public static void main(String[] args) {

        Show show = new Show("7 PM");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        // Asha books three seats
        Booking booking1 =
                new Booking(asha, show, a1, a2, f5);

        // Ravi tries an already booked seat
        Booking booking2 =
                new Booking(ravi, show, a2);

        // Ravi books a free recliner
        Booking booking3 =
                new Booking(ravi, show, r1);

        // Asha cancels before the show
        booking1.cancel();

        // A2 is free again
        Booking booking4 =
                new Booking(neha, show, a2);
    }
}
