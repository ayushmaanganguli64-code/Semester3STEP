
import java.util.Arrays;

class LibraryMember {
    private final String memberId;
    private final int borrowLimit;
    private int[] fineHistory;
    private int fineCount;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.fineHistory = new int[10];
        this.fineCount = 0;
    }

    protected void chargeFine(int amount) {
        if (amount > 0 && fineCount < fineHistory.length) {
            fineHistory[fineCount++] = amount;
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }
        return total;
    }
}

class StudentMember extends LibraryMember {
    private final String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class Pro3 {
    public static void main(String[] args) {
        StudentMember s = new StudentMember("STU5", 3, "CSE");
        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        System.out.println(Arrays.toString(history));
        history[0] = 999;
        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}
