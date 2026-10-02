
import java.util.*;

interface NotificationChannel {
    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[Email → " + student.name + "] "
                + message);
    }
}

class SmsChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[SMS → " + student.name + "] "
                + message);
    }
}

class AppChannel implements NotificationChannel {

    public void send(Student student, String message) {
        System.out.println("[App → " + student.name + "] "
                + message);
    }
}

class Student {
    String name;
    String department;

    ArrayList<NotificationChannel> channels =
            new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    ArrayList<String> departments =
            new ArrayList<>();

    Notice(String title, String... departments) {

        if (title == null || title.isEmpty()) {
            System.out.println("Cannot post notice: Title is required.");
            return;
        }

        this.title = title;

        for (String department : departments) {
            this.departments.add(department);
        }
    }

    boolean isValid() {
        return title != null &&
                !title.isEmpty() &&
                !departments.isEmpty();
    }
}

class NoticeBoard {
    ArrayList<Student> students =
            new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {

        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.print("Notice '" + notice.title
                + "' posted to ");

        for (int i = 0; i < notice.departments.size(); i++) {
            System.out.print(notice.departments.get(i));

            if (i < notice.departments.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(".");

        // Send the notice to matching students
        for (Student student : students) {

            if (notice.departments.contains(student.department)) {

                for (NotificationChannel channel :
                        student.channels) {

                    channel.send(student, notice.title);
                }
            }
        }
    }
}

public class Que5 {
    public static void main(String[] args) {

        Student asha = new Student("Asha", "CSE");
        Student ravi = new Student("Ravi", "ECE");

        // Asha wants Email and App
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        // Ravi wants SMS
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        // Notice for CSE
        Notice notice1 =
                new Notice("Lab Closed Tomorrow", "CSE");

        board.postNotice(notice1);

        System.out.println();

        // Notice for both departments
        Notice notice2 =
                new Notice("Fee Deadline Extended",
                        "CSE", "ECE");

        board.postNotice(notice2);

        System.out.println();

        // Notice with no department
        Notice notice3 =
                new Notice("Sports Day");

        board.postNotice(notice3);
    }
}
