import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Reporting class generates reports on employees, such as total pay by job title and division.
 */
public class Reporting {

    // Get full-time employee information
    public static List<Employee> getFullTimeEmployees() {
        return EmployeeMod.getAllEmployees(); // Assuming all employees are full-time
    }

    // Calculate total pay by job title
    public static Map<String, Double> getTotalPayByJobTitle() {
        Map<String, Double> payByTitle = new HashMap<>();
        for (Employee emp : EmployeeMod.getAllEmployees()) {
            payByTitle.put(emp.getJobTitle(), 
                payByTitle.getOrDefault(emp.getJobTitle(), 0.0) + emp.getSalary());
        }
        return payByTitle;
    }

    // Calculate total pay by division
    public static Map<String, Double> getTotalPayByDivision() {
        Map<String, Double> payByDivision = new HashMap<>();
        for (Employee emp : EmployeeMod.getAllEmployees()) {
            payByDivision.put(emp.getDivision(), 
                payByDivision.getOrDefault(emp.getDivision(), 0.0) + emp.getSalary());
        }
        return payByDivision;
    }

    // Generate a report of full-time employee information
    public static String generateFullTimeEmployeeReport() {
        StringBuilder report = new StringBuilder("Full-Time Employee Information:\n");
        report.append("--------------------------------------------------\n");
        for (Employee emp : getFullTimeEmployees()) {
            report.append(emp.toString()).append("\n");
            report.append("--------------------------------------------------\n");
        }
        return report.toString();
    }
}
