import java.util.*;

class PinValidator {
    String pin;

    PinValidator(String pin) {
        this.pin = pin;
    }

    void checkPinLength() {
        // Check PIN length
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        PinValidator obj = new PinValidator(pin);
        obj.checkPinLength();

        sc.close();
    }
}
