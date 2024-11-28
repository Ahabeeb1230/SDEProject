import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMod {
    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (name, ssn, job_title, division, salary, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setString(6, employee.getHireDate());
            stmt.executeUpdate();
        }
    }

    public Employee getEmployeeById(int empId) throws SQLException {
        String query = "SELECT * FROM employees WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employees SET name = ?, ssn = ?, job_title = ?, division = ?, salary = ?, hire_date = ? WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setString(6, employee.getHireDate());
            stmt.setInt(7, employee.getEmpId());
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int empId) throws SQLException {
        String query = "DELETE FROM employees WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId);
            stmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String query = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
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
        return employees;
    }
}
