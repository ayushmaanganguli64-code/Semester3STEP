import java.util.*;

class TypingChecker {
    String original;
    String typed;

    // Constructor
    TypingChecker(String original, String typed) {
        this.original = original;
        this.typed = typed;
    }

    // Check typing accuracy
    void checkTypingAccuracy() {
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d%n",
                matched, original.length());

        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println(
                "First Mismatch at position " + (firstMismatch + 1)
                + " ('" + original.charAt(firstMismatch)
                + "' vs '" + typed.charAt(firstMismatch) + "')"
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        TypingChecker obj = new TypingChecker(original, typed);
        obj.checkTypingAccuracy();

        sc.close();
    }
}
