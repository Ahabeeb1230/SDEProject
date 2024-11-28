public class Employee {
    private int empId;
    private String name;
    private String ssn;
    private String jobTitle;
    private String division;
    private double salary;
    private String hireDate;

    // Constructor
    public Employee(int empId, String name, String ssn, String jobTitle, String division, double salary, String hireDate) {
        this.empId = empId;
        this.name = name;
        this.ssn = ssn;
        this.jobTitle = jobTitle;
        this.division = division;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", SSN=" + ssn + ", Job Title=" + jobTitle +
               ", Division=" + division + ", Salary=" + salary + ", Hire Date=" + hireDate + "]";
    }
}
