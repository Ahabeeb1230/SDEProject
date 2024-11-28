import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The EmployeeMod class provides methods to interact with the employees table in the database.
 * It includes operations for adding, retrieving, updating, and deleting employee records.
 */
public class EmployeeMod {

    /**
     * Adds a new employee record to the database.
     *
     * @param employee The Employee object containing the details to add.
     * @throws SQLException If a database error occurs.
     */
    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (name, ssn, job_title, division, salary, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set parameters for the SQL query
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setString(6, employee.getHireDate());
            stmt.executeUpdate(); // Execute the query
        }
    }

    /**
     * Retrieves an employee record by their ID.
     *
     * @param empId The ID of the employee to retrieve.
     * @return The Employee object if found, otherwise null.
     * @throws SQLException If a database error occurs.
     */
    public Employee getEmployeeById(int empId) throws SQLException {
        String query = "SELECT * FROM employees WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId); // Set the employee ID in the query
            try (ResultSet rs = stmt.executeQuery()) { // Execute the query and get results
                if (rs.next()) {
                    // Create an Employee object from the retrieved data
                    return new Employee(
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("job_title"),
                        rs.getString("division"),
                        rs.getDouble("salary"),
                        rs.getString("hire_date")
                    );
                }
            }
        }
        return null; // Return null if no record is found
    }

    /**
     * Updates an existing employee record in the database.
     *
     * @param employee The Employee object containing updated details.
     * @throws SQLException If a database error occurs.
     */
    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employees SET name = ?, ssn = ?, job_title = ?, division = ?, salary = ?, hire_date = ? WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            // Set parameters for the SQL query
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setString(6, employee.getHireDate());
            stmt.setInt(7, employee.getEmpId());
            stmt.executeUpdate(); // Execute the query
        }
    }

    /**
     * Deletes an employee record from the database by their ID.
     *
     * @param empId The ID of the employee to delete.
     * @throws SQLException If a database error occurs.
     */
    public void deleteEmployee(int empId) throws SQLException {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId); // Set the employee ID in the query
            stmt.executeUpdate(); // Execute the query
        }
    }

    /**
     * Retrieves all employee records from the database.
     *
     * @return A list of Employee objects representing all employees.
     * @throws SQLException If a database error occurs.
     */
    public List<Employee> getAllEmployees() throws SQLException {
        String query = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>(); // List to store retrieved employees
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) { // Execute the query and get results
            while (rs.next()) {
                // Add each retrieved employee to the list
                employees.add(new Employee(
                    rs.getInt("emp_id"),
                    rs.getString("name"),
                    rs.getString("ssn"),
                    rs.getString("job_title"),
                    rs.getString("division"),
                    rs.getDouble("salary"),
                    rs.getString("hire_date")
                ));
            }
        }
        return employees; // Return the list of employees
    }
}
