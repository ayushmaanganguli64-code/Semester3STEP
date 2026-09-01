import java.util.*;

class MembershipCard {
    static String libraryName;
    static String validUntil;

    String studentName;

    // Runs only once
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    // Constructor
    MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    // Print confirmation
    void printCard() {
        System.out.println(
            "Membership card issued: " + studentName
        );
    }
}

public class Main {
    public static void main(String[] args) {

        String[] names = {
            "Ananya",
            "Rohan",
            "Priya",
            "Arjun",
            "Sneha"
        };

        for (int i = 0; i < names.length; i++) {

            MembershipCard obj =
                new MembershipCard(names[i]);

            obj.printCard();
        }
    }
}
