/**
 * The Employee class represents an employee in the system.
 * It stores attributes like ID, name, SSN, job title, division, and salary.
 */
public class Employee {
    private static int idCounter = 1; // Auto-incrementing employee ID
    private int empId;
    private String name;
    private String ssn;
    private String jobTitle;
    private String division;
    private double salary;

    // Constructor for creating an employee
    public Employee(String name, String ssn, String jobTitle, String division, double salary) {
        this.empId = idCounter++;
        this.name = name;
        this.ssn = ssn;
        this.jobTitle = jobTitle;
        this.division = division;
        this.salary = salary;
    }

    // Getters and setters
    public int getEmpId() { return empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSsn() { return ssn; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Search functionality
    public boolean matches(String query) {
        return name.contains(query) || ssn.contains(query) || String.valueOf(empId).equals(query);
    }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", SSN=" + ssn + 
               ", Job Title=" + jobTitle + ", Division=" + division + 
               ", Salary=" + salary + "]";
    }
}
