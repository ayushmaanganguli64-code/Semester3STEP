abstract class WashType {
    String name;
    int duration;
    double charge;

    WashType(String name, int duration, double charge) {
        this.name = name;
        this.duration = duration;
        this.charge = charge;
    }

    double getCharge() {
        return charge;
    }
}

class QuickWash extends WashType {
    QuickWash() {
        super("Quick", 30, 20);
    }
}

class NormalWash extends WashType {
    NormalWash() {
        super("Normal", 45, 30);
    }
}

class HeavyWash extends WashType {
    HeavyWash() {
        super("Heavy", 60, 45);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType washType;

    WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }
}

class WashingMachine {
    String name;
    private boolean busy = false;

    WashingMachine(String name) {
        this.name = name;
    }

    void startWash(Student student, WashType type) {

        if (busy) {
            System.out.println("Machine " + name + " is currently busy.");
            return;
        }

        busy = true;

        new WashCycle(student, this, type);

        System.out.println(type.name + " wash started on " + name
                + " for " + student.name + " (" + type.duration + " min).");

        System.out.printf("Charge: ₹%.2f%n", type.getCharge());
    }

    void completeWash() {
        if (busy) {
            busy = false;
            System.out.println(name + " cycle completed.");
            System.out.println(name + " is now free.");
        }
    }
}

public class Que1 {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        // Asha starts a quick wash
        m1.startWash(asha, new QuickWash());

        // Ravi tries the busy machine
        m1.startWash(ravi, new HeavyWash());

        // Ravi uses another machine
        m2.startWash(ravi, new HeavyWash());

        // M1 finishes its wash
        m1.completeWash();

        // Neha can now use M1
        m1.startWash(neha, new NormalWash());
    }
}
