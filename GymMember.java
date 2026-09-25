public class GymMember {
    private static int membersEnrolled = 2000; // Shared static counter starting at 2000[cite: 7]
    public final String membershipNumber;     // Final membership number[cite: 7]
    private int feesPaid;

    // Overloaded constructor receiving monthly fee[cite: 7]
    public GymMember(int monthlyFee) {
        membersEnrolled++;[cite: 7]
        this.membershipNumber = "GYM-" + membersEnrolled;[cite: 7]
        this.feesPaid = 0;
    }

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");[cite: 7]
        }
        membersEnrolled++;[cite: 7]
        this.membershipNumber = "GYM-" + membersEnrolled;[cite: 7]
        this.feesPaid = 0;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled - 2000; // Counter tracking newly enrolled[cite: 7]
    }

    public void payFee(int amount) {
        if (amount > 0) {
            this.feesPaid += amount;[cite: 7]
        }
    }

    // Overloaded payFee method delegating to 1-argument version[cite: 7]
    public void payFee(int amount, String mode) {
        payFee(amount); // Reuses flat-amount payFee internally[cite: 7]
    }

    public int getFeesPaid() {
        return feesPaid;[cite: 7]
    }

    // Validates pattern "G" + 2 digits + 1 uppercase letter without regex[cite: 7]
    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;[cite: 7]
        }
        return code.charAt(0) == 'G' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));[cite: 7]
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (members != null) {
            for (GymMember member : members) {
                if (member == null) {
                    nullSkipped++; // Null safe check[cite: 7]
                } else {
                    processed++;
                    if (member instanceof GroupClassMember) {
                        groupCount++;[cite: 7]
                    } else {
                        individualCount++;[cite: 7]
                    }
                }
            }
        }

        return String.format("%d processed | %d null skipped | %d group %d individual",
                             processed, nullSkipped, groupCount, individualCount);[cite: 7]
    }

    public static void main(String[] args) {
        GymMember m1 = new GymMember(1000);[cite: 7]
        System.out.println("Member 1 Number: " + m1.membershipNumber); // GYM-2001[cite: 7]
        System.out.println("Members Enrolled Count: " + getMembersEnrolled()); // 1[cite: 7]

        System.out.println("\nReferral Code Validations:");
        System.out.println("G45B valid? " + isValidReferralCode("G45B")); // true[cite: 7]
        System.out.println("G4B valid? " + isValidReferralCode("G4B"));   // false[cite: 7]
        System.out.println("X45B valid? " + isValidReferralCode("X45B")); // false[cite: 7]

        System.out.println("\nOverloaded Fee Payment Test:");
        m1.payFee(500);[cite: 7]
        m1.payFee(500, "UPI");[cite: 7]
        System.out.println("Total Fees Paid: " + m1.getFeesPaid()); // Expected: 1000[cite: 7]

        System.out.println("\nWeekly Check-in Processing Test:");
        GymMember[] batch = {
            new GroupClassMember(1500, "Zumba"),[cite: 7]
            null,[cite: 7]
            new GymMember(1000)[cite: 7]
        };
        System.out.println(processWeeklyCheckIn(batch));[cite: 7]
    }
}

class GroupClassMember extends GymMember {
    private final String className;

    public GroupClassMember(int monthlyFee, String className) {
        super(monthlyFee);[cite: 7]
        this.className = className;
    }

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
