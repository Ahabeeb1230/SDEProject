/**
 * The Employee class represents an employee in the system.
 * It encapsulates employee attributes like ID, name, SSN, job title, division, salary, and hire date.
 */
public class Employee {
    private int empId; // Unique identifier for the employee
    private String name; // Full name of the employee
    private String ssn; // Social Security Number (SSN) of the employee
    private String jobTitle; // Job title of the employee
    private String division; // Division where the employee works
    private double salary; // Salary of the employee
    private String hireDate; // Hire date of the employee in YYYY-MM-DD format

    // Constructor to initialize the Employee object with all attributes
    public Employee(int empId, String name, String ssn, String jobTitle, String division, double salary, String hireDate) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.jobTitle = jobTitle;
        this.division = division;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Getter and Setter methods for each attribute to access and modify them

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }

    // Overriding the toString method to provide a readable representation of an Employee object
    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", SSN=" + ssn + 
               ", Job Title=" + jobTitle + ", Division=" + division + 
               ", Salary=" + salary + ", Hire Date=" + hireDate + "]";
    }
}
