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
        return "Standard | Sessions: " + sessionsAttended;[cite: 7]
    }
}

class PremiumMember extends GymMember {
    private final String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public String displayInfo() {
        return "Premium | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();[cite: 7]
    }
}

public class pro4 {

    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder(); // Built using StringBuilder[cite: 7]

        if (members != null) {
            for (GymMember member : members) {
                if (member != null) {
                    sb.append(member.displayInfo());[cite: 7]
                    
                    // instanceof check guarding safe downcast[cite: 7]
                    if (member instanceof PremiumMember) {
                        PremiumMember pm = (PremiumMember) member;[cite: 7]
                        sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");[cite: 7]
                    }
                    sb.append(" | ");[cite: 7]
                }
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),[cite: 7]
            new PremiumMember("MEM7", 2000, "Coach Riya")[cite: 7]
        };

        System.out.println("Batch Announcement Output:");
        System.out.println(batchPrint(members));[cite: 7]

        System.out.println("\nDemonstrating ClassCastException on unsafe downcast:");
        GymMember plain = new GymMember("MEM8", 1000);[cite: 7]
        try {
            PremiumMember bad = (PremiumMember) plain; // Unsafe downcast throws ClassCastException[cite: 7]
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught successfully at runtime!");[cite: 7]
        }
    }
}
