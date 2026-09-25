class GymMember {
    private final String memberId;
    private final int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");[cite: 7]
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        this.sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;[cite: 7]
    }
}

class PremiumMember extends GymMember {
    private final String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);[cite: 7]
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();[cite: 7]
    }
}

// Multilevel Inheritance: EliteMember extends PremiumMember[cite: 7]
class EliteMember extends PremiumMember {
    private final String lockerNumber;

    public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);[cite: 7]
        this.lockerNumber = lockerNumber;
    }

    public String getLockerNumber() {
        return lockerNumber;
    }

    @Override
    public String displayInfo() {
        return "Elite Member | Trainer: " + getTrainerName() + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();[cite: 7]
    }
}

// Hierarchical Inheritance: GroupClassMember extends GymMember directly[cite: 7]
class GroupClassMember extends GymMember {
    private final String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);[cite: 7]
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String displayInfo() {
        return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();[cite: 7]
    }
}

public class pro2 {

    // Classifies member generation using instanceof checks[cite: 7]
    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";[cite: 7]
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";[cite: 7]
        } else if (member instanceof PremiumMember) {
            return "Multilevel descendant (2 generations deep)";
        } else {
            return "General Member";
        }
    }

    // Polymorphically sums total sessions[cite: 7]
    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (GymMember m : members) {
                if (m != null) {
                    total += m.getSessionsAttended(); // Dynamic method dispatch[cite: 7]
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        GymMember standard = new GymMember("MEM1", 1000);[cite: 7]
        PremiumMember premium = new PremiumMember("MEM2", 2000, "Coach Riya");[cite: 7]
        EliteMember elite = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");[cite: 7]
        GroupClassMember group = new GroupClassMember("MEM4", 1500, "Zumba");[cite: 7]

        System.out.println(standard.displayInfo());[cite: 7]
        System.out.println(premium.displayInfo());[cite: 7]
        System.out.println(elite.displayInfo());[cite: 7]
        System.out.println(group.displayInfo());[cite: 7]

        System.out.println("\nClassifications:");
        System.out.println("Elite: " + classifyGeneration(elite));[cite: 7]
        System.out.println("Group: " + classifyGeneration(group));[cite: 7]

        // Populate sessions: premium=3, elite=2, group=4[cite: 7]
        for (int i = 0; i < 3; i++) premium.attendSession();
        for (int i = 0; i < 2; i++) elite.attendSession();
        for (int i = 0; i < 4; i++) group.attendSession();

        GymMember[] fleet = { premium, elite, group };[cite: 7]
        System.out.println("\nTotal Sessions Attended: " + getTotalSessionsAttended(fleet)); // Expected: 9[cite: 7]
    }
}
