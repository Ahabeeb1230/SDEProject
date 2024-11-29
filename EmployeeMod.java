import java.util.ArrayList;
import java.util.List;

/**
 * The EmployeeMod class manages the list of employees and provides operations for adding,
 * updating, deleting, and retrieving employee information.
 */
public class EmployeeMod {
    private static List<Employee> employeeList = new ArrayList<>();

    // Add a new employee
    public static void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Retrieve all employees
    public static List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Search employees by a query
    public static List<Employee> searchEmployees(String query) {
        List<Employee> results = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.matches(query)) {
                results.add(emp);
            }
        }
        return results;
    }

    // Find an employee by ID
    public static Employee findById(int id) {
        for (Employee emp : employeeList) {
            if (emp.getEmpId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Update an employee's details
    public static boolean updateEmployee(int empId, String newName, String newDivision) {
        Employee emp = findById(empId);
        if (emp != null) {
            if (newName != null && !newName.isEmpty()) emp.setName(newName);
            if (newDivision != null && !newDivision.isEmpty()) emp.setDivision(newDivision);
            return true;
        }
        return false;
    }

    // Update salary for employees within a specific range
    public static void updateSalary(double minSalary, double maxSalary, double percentageIncrease) {
        for (Employee emp : employeeList) {
            if (emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary) {
                emp.setSalary(emp.getSalary() + emp.getSalary() * (percentageIncrease / 100));
            }
        }
    }

    // Delete an employee by ID
    public static boolean removeEmployee(int empId) {
        return employeeList.removeIf(emp -> emp.getEmpId() == empId);
    }
}
