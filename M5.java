import java.util.*;

class WordProfiler {
    String review;

    // Constructor
    WordProfiler(String review) {
        this.review = review;
    }

    // Classify word lengths
    void classifyWordLengths() {
        String[] words = review.split(" ");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (String word : words) {
            int length = word.length();

            if (length <= 4) {
                shortWords++;
            } else if (length <= 8) {
                mediumWords++;
            } else {
                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        WordProfiler obj = new WordProfiler(review);
        obj.classifyWordLengths();

        sc.close();
    }
}
