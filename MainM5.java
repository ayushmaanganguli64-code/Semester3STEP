class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class MainM5 {
    public static void main(String[] args) {
        new Employee("Rahul", 50000);
        new Employee("Sneha", 60000);
        new Employee("Amit", 55000);

        Employee.printCompanyInfo();
    }
}
