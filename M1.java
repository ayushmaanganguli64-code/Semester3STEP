import java.util.*;

class SeatChecker {
    int[] seatNumbers;

    // Constructor
    SeatChecker(int[] seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    // Check duplicate seats
    void checkDuplicateSeats() {
        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: "
                            + seatNumbers[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}

public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat number: ");
            seats[i] = sc.nextInt();
        }

        SeatChecker obj = new SeatChecker(seats);
        obj.checkDuplicateSeats();

        sc.close();
    }
}
