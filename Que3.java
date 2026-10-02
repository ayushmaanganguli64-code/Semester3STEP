import java.util.*;

abstract class Question {
    String question;
    int marks;

    Question(String question, int marks) {
        this.question = question;
        this.marks = marks;
    }

    abstract boolean checkAnswer(String answer);
}

class MCQQuestion extends Question {
    String correctAnswer;

    MCQQuestion(String question, String correctAnswer, int marks) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {
    boolean correctAnswer;

    TrueFalseQuestion(String question, boolean correctAnswer, int marks) {
        super(question, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Attempt {
    Student student;
    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<String> answers = new ArrayList<>();
    boolean submitted = false;

    Attempt(Student student) {
        this.student = student;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }

    void answer(String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        answers.add(answer);
        System.out.println("Answer recorded.");
    }

    void submit() {
        submitted = true;

        int total = 0;
        int score = 0;

        System.out.println("\nExam submitted by " + student.name);

        for (int i = 0; i < questions.size(); i++) {
            total += questions.get(i).marks;

            if (questions.get(i).checkAnswer(answers.get(i))) {
                score += questions.get(i).marks;
                System.out.println("Question " + (i + 1) +
                        ": Correct (" + questions.get(i).marks + " points)");
            } else {
                System.out.println("Question " + (i + 1) +
                        ": Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class Que3 {
    public static void main(String[] args) {

        Student student = new Student("Student 1");

        Attempt attempt = new Attempt(student);

        System.out.println("Exam A started by Student 1.");

        Question q1 =
                new MCQQuestion("Which is a Java keyword?",
                        "C", 5);

        Question q2 =
                new TrueFalseQuestion("Java is object oriented?",
                        false, 5);

        attempt.addQuestion(q1);
        attempt.addQuestion(q2);

        attempt.answer("C");
        attempt.answer("true");

        attempt.submit();

        // Trying to change answer after submission
        attempt.answer("A");
    }
}
