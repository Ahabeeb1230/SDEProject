import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Reporting {
    public void generatePayStatementHistory(int empId) throws SQLException {
        String query = "SELECT * FROM pay_statements WHERE emp_id = ?";
        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Pay Statement History:");
                while (rs.next()) {
                    System.out.println("Date: " + rs.getDate("statement_date") +
                                       ", Amount: " + rs.getDouble("amount"));
                }
            }
        }
    }

    public Map<String, Double> getTotalPayByJobTitle() throws SQLException {
        String query = "SELECT job_title, SUM(salary) AS total_pay FROM employees GROUP BY job_title";
        Map<String, Double> results = new HashMap<>();
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                results.put(rs.getString("job_title"), rs.getDouble("total_pay"));
            }
        }
        return results;
    }

    public Map<String, Double> getTotalPayByDivision() throws SQLException {
        String query = "SELECT division, SUM(salary) AS total_pay FROM employees GROUP BY division";
        Map<String, Double> results = new HashMap<>();
        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                results.put(rs.getString("division"), rs.getDouble("total_pay"));
            }
        }
        return results;
    }
}
