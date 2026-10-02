import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(double marks, long lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    // 10% penalty for every late day
    double applyPenalty(double marks, long lateDays) {
        return marks - (marks * 0.10 * lateDays);
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    // 20% penalty for every late day
    double applyPenalty(double marks, long lateDays) {
        return marks - (marks * 0.20 * lateDays);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    LocalDate submissionDate;

    private String status = "Submitted";
    double finalMarks;

    Submission(Student student, Assignment assignment,
               LocalDate submissionDate) {

        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
    }

    void grade(double awardedMarks) {

        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission.");
            return;
        }

        long lateDays = 0;

        if (submissionDate.isAfter(assignment.dueDate)) {
            lateDays = ChronoUnit.DAYS.between(
                    assignment.dueDate, submissionDate);
        }

        finalMarks = assignment.applyPenalty(awardedMarks, lateDays);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%d%n",
                student.name, finalMarks, assignment.maxMarks);

        System.out.println("Status: " + status);
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" +
                    assignment.title + "' has already been graded.");
        } else {
            System.out.println("Resubmission allowed.");
        }
    }
}

public class Que2 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab",
                50,
                LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay",
                50,
                LocalDate.of(2026, 3, 12));

        // Asha submits on time
        Submission s1 = new Submission(
                asha,
                coding,
                LocalDate.of(2026, 3, 10));

        System.out.println("Asha's submission received (on time).");
        System.out.println("Status: Submitted.");

        s1.grade(45);

        // Ravi submits 2 days late
        Submission s2 = new Submission(
                ravi,
                written,
                LocalDate.of(2026, 3, 14));

        System.out.println("\nRavi's submission received (2 days late).");
        System.out.println("Status: Submitted.");

        s2.grade(40);

        // Asha tries to submit again
        s1.resubmit();
    }
}
