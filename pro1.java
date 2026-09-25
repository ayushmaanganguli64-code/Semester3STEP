public class GymMember {
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

    public String getMemberId() {
        return memberId;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public String displayInfo() {
        return "Standard Member | Sessions: " + sessionsAttended;[cite: 7]
    }

    
    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        if (memberIds != null) {
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);[cite: 7]
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }

        return "Signed Up: " + signedUp + "\nRejected: " + rejected;[cite: 7]
    }

    public static void main(String[] args) {
      
        try {
            new GymMember("GM1", 1000);[cite: 7]
        } catch (IllegalArgumentException e) {
            System.out.println("GM1: construction rejected");[cite: 7]
        }

       
        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");[cite: 7]
        p.attendSession();[cite: 7]
        p.attendSession();[cite: 7]
        System.out.println("Sessions Attended: " + p.getSessionsAttended()); 

        String[] batch = {"MEM1", "GM1", "MEM2", "", "MEM3"};[cite: 7]
        System.out.println("\nBatch Sign-up Result:");
        System.out.println(signUpBatch(batch, 1000));[cite: 7]
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
        return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();[cite: 7]
    }
}
