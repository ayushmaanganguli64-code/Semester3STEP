import java.util.*;

class ISBNValidator {
    String rawCode;

    ISBNValidator(String rawCode) {
        this.rawCode = rawCode;
    }

    String normalizeCode() {
        rawCode = rawCode.trim();

        // Uppercase publisher code
        String publisher = rawCode.substring(0, 3).toUpperCase();
        String rest = rawCode.substring(3);

        return publisher + rest;
    }

    String validateAndFormat(String code) {

        // Check total length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check publisher
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(publisher)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String rawCode = sc.nextLine();

        ISBNValidator obj = new ISBNValidator(rawCode);

        String code = obj.normalizeCode();

        System.out.println(obj.validateAndFormat(code));

        sc.close();
    }
}
