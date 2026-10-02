abstract class MembershipPlan {
    double baseRate = 1000;

    abstract double calculateFee();
}

class MonthlyPlan extends MembershipPlan {

    double calculateFee() {
        return baseRate;
    }
}

class QuarterlyPlan extends MembershipPlan {

    double calculateFee() {
        return baseRate * 3 * 0.90;
    }
}

class AnnualPlan extends MembershipPlan {

    double calculateFee() {
        return baseRate * 12 * 0.75;
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status = "Active";

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;

        System.out.println(plan.getClass().getSimpleName()
                + " membership created for " + member.name);

        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.name
                    + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: "
                    + member.name + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.name
                    + "'s membership frozen.");
            System.out.println("Status: " + status);
        } else {
            System.out.println("Cannot freeze an "
                    + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name
                    + "'s membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze an "
                    + status + " membership.");
        }
    }

    void expire() {
        status = "Expired";

        System.out.println(member.name
                + "'s membership expired.");
        System.out.println("Status: " + status);
    }
}

public class Que4 {
    public static void main(String[] args) {

        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership =
                new Membership(asha, new QuarterlyPlan());

        System.out.println();

        Membership raviMembership =
                new Membership(ravi, new MonthlyPlan());

        System.out.println();

        // Asha checks in
        ashaMembership.checkIn();

        // Asha freezes membership
        ashaMembership.freeze();

        // Frozen membership cannot be used
        ashaMembership.checkIn();

        System.out.println();

        // Ravi's membership expires
        raviMembership.expire();

        // Expired membership cannot be frozen
        raviMembership.freeze();
    }
}
