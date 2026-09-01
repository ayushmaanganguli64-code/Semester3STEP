import java.util.*;

class Participant {
    String name;
    String teamName;
    boolean registered;

    // Constructor for team members
    Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // Constructor for solo members
    Participant(String name) {
        this(name, "Unassigned");
    }

    // Print participant details
    void printStatus() {
        System.out.println(
            name + " | " + teamName + " | Registered: " + registered
        );
    }
}

public class Main {
    public static void main(String[] args) {

        String[] names = {
            "Ravi", "Meera", "Karthik", "Divya"
        };

        String[] teamNames = {
            "ByteBusters", "", "CodeCrafters", ""
        };

        for (int i = 0; i < names.length; i++) {

            Participant obj;

            // Choose constructor
            if (teamNames[i].isEmpty()) {
                obj = new Participant(names[i]);
            } else {
                obj = new Participant(names[i], teamNames[i]);
            }

            obj.printStatus();
        }
    }
}
