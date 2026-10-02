class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    boolean canTakeLeave(int days) {
        return true;
    }
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name) {
        super(name);
    }

    // Full-time employees can take up to 30 days
    boolean canTakeLeave(int days) {
        return days <= 30;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name) {
        super(name);
    }

    // Part-time employees can take up to 15 days
    boolean canTakeLeave(int days) {
        return days <= 15;
    }
}

class LeaveRequest {
    Employee employee;
    String startDate;
    String endDate;
    String status = "Pending";

    LeaveRequest(Employee employee, String startDate, String endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println(employee.name + "'s leave request approved.");
        } else {
            System.out.println("Cannot approve this request.");
        }
    }

    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(employee.name + "'s leave request rejected.");
        } else {
            System.out.println("Cannot reject this request.");
        }
    }

    void changeStatus(String newStatus) {
        // Approved or Rejected cannot go back to Pending
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + newStatus + ".");
        } else {
            status = newStatus;
        }
    }
}

public class Que2 {
    public static void main(String[] args) {

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest request1 =
                new LeaveRequest(john, "Jan 1", "Jan 5");

        System.out.println("Leave request submitted for John (Jan 1-5).");
        System.out.println("Status: " + request1.status);

        request1.approve();
        System.out.println("Status: " + request1.status);

        LeaveRequest request2 =
                new LeaveRequest(jane, "Feb 10", "Feb 11");

        System.out.println("\nLeave request submitted for Jane (Feb 10-11).");
        System.out.println("Status: " + request2.status);

        request2.reject();
        System.out.println("Status: " + request2.status);

        // Trying an invalid state change
        request1.changeStatus("Pending");
    }
}
