// Problem 5
class LibraryMember {
    private static int membersEnrolled = 0;
    public final String memberNumber;
    private int booksBorrowed;

    public LibraryMember(int borrowLimit) {
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
        this.booksBorrowed = 0;
    }

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
        this.booksBorrowed = 0;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public void borrowBook() {
        this.booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        return code.charAt(0) == 'R' &&
               Character.isDigit(code.charAt(1)) &&
               Character.isDigit(code.charAt(2)) &&
               Character.isUpperCase(code.charAt(3));
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int facultyCount = 0;
        int regularCount = 0;

        if (members != null) {
            for (LibraryMember member : members) {
                if (member == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (member instanceof FacultyMember) {
                        facultyCount++;
                    } else {
                        regularCount++;
                    }
                }
            }
        }

        return String.format("%d processed | %d null skipped | %d faculty %d regular",
                             processed, nullSkipped, facultyCount, regularCount);
    }
}

class FacultyMember extends LibraryMember {
    private final String department;

    public FacultyMember(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }

    public FacultyMember(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class Pro5 {
    public static void main(String[] args) {
        LibraryMember m1 = new LibraryMember(3);
        System.out.println(m1.memberNumber);
        System.out.println(LibraryMember.getMembersEnrolled());

        System.out.println(LibraryMember.isValidRenewalCode("R12A"));
        System.out.println(LibraryMember.isValidRenewalCode("R1A"));
        System.out.println(LibraryMember.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");
        System.out.println(m1.getBooksBorrowed());

        LibraryMember[] batch = {
            new FacultyMember(5, "Physics"),
            null,
            new LibraryMember(3)
        };
        System.out.println(LibraryMember.processNightlyAudit(batch));
    }
}
