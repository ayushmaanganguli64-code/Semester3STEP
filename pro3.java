import java.util.Arrays;

public class GymMember {
    private final String memberId;
    private final int monthlyFee;
    private int[] lateFeeHistory;[cite: 7]
    private int lateFeeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");[cite: 7]
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.lateFeeHistory = new int[10]; // Capacity constraint: up to 10 late fees[cite: 7]
        this.lateFeeCount = 0;
    }

    protected void chargeLateFee(int amount) {
        if (amount > 0 && lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;[cite: 7]
        }
    }

    // Defensive copy return[cite: 7]
    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);[cite: 7]
    }

    public int getTotalLateFees() {
        int total = 0;
        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }
        return total;
    }

    public static void main(String[] args) {
        PremiumMember p = new PremiumMember("MEM5", 2000, "Coach Riya");[cite: 7]
        
        // Halves amount to 100 via override[cite: 7]
        p.chargeLateFee(200);[cite: 7]
        System.out.println("Total Late Fees: " + p.getTotalLateFees()); // Output: 100[cite: 7]

        // Test defensive copy encapsulation[cite: 7]
        int[] history = p.getLateFeeHistory();[cite: 7]
        System.out.println("Recorded History: " + Arrays.toString(history)); // [100][cite: 7]
        
        history[0] = 999; // Tamper attempt[cite: 7]
        System.out.println("After Tampering Local Array: " + Arrays.toString(p.getLateFeeHistory())); // Should still be [100][cite: 7]
    }
}

class PremiumMember extends GymMember {
    private final String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        // Halves amount and delegates to parent implementation[cite: 7]
        super.chargeLateFee(amount / 2);[cite: 7]
    }
}
