import java.util.*;

class WordEncoder {
    String sentence;

    WordEncoder(String sentence) {
        this.sentence = sentence;
    }

    String reverseEachWord() {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Reverse each word
        for (String word : words) {
            StringBuilder temp = new StringBuilder(word);
            result.append(temp.reverse()).append(" ");
        }

        return result.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        WordEncoder obj = new WordEncoder(sentence);

        System.out.println(obj.reverseEachWord());

        sc.close();
    }
}
