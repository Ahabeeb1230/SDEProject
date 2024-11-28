import java.sql.*; // Import SQL classes for database interaction
import java.util.HashMap; // Import HashMap to store results
import java.util.Map; // Import Map interface

/**
 * The Reporting class handles reporting-related queries for the employee management system.
 * It includes methods to fetch pay statement history, and total pay by job title and division.
 */
public class Reporting {

    /**
     * Generates and displays the pay statement history for a specific employee.
     *
     * @param empId The ID of the employee whose pay statement history is to be retrieved.
     * @throws SQLException If a database access error occurs.
     */
    public void generatePayStatementHistory(int empId) throws SQLException {
        // SQL query to fetch all pay statements for a specific employee
        String query = "SELECT * FROM pay_statements WHERE emp_id = ?";

        // Use try-with-resources to ensure proper closure of resources
        try (Connection conn = DatabaseHelper.getConnection(); // Establish database connection
             PreparedStatement stmt = conn.prepareStatement(query)) { // Prepare SQL query
             
            // Set the employee ID in the query
            stmt.setInt(1, empId);

            // Execute the query and get the result set
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Pay Statement History:");
                
                // Loop through the result set and print each record
                while (rs.next()) {
                    System.out.println("Date: " + rs.getDate("statement_date") + // Retrieve and print statement date
                                       ", Amount: " + rs.getDouble("amount")); // Retrieve and print statement amount
                }
            }
        }
    }

    /**
     * Calculates and retrieves the total salary expenditure grouped by job title.
     *
     * @return A Map where the key is the job title and the value is the total pay for that job title.
     * @throws SQLException If a database access error occurs.
     */
    public Map<String, Double> getTotalPayByJobTitle() throws SQLException {
        // SQL query to calculate total pay by job title
        String query = "SELECT job_title, SUM(salary) AS total_pay FROM employees GROUP BY job_title";

        // Map to store the results (job title -> total pay)
        Map<String, Double> results = new HashMap<>();

        // Use try-with-resources to handle database connection and statement
        try (Connection conn = DatabaseHelper.getConnection(); // Establish connection
             Statement stmt = conn.createStatement(); // Create a simple SQL statement
             ResultSet rs = stmt.executeQuery(query)) { // Execute the query and get the result set

            // Loop through the result set and populate the map
            while (rs.next()) {
                results.put(rs.getString("job_title"), rs.getDouble("total_pay"));
                // Add job title as key and total pay as value to the map
            }
        }
        return results; // Return the map of job titles and their total pay
    }

    /**
     * Calculates and retrieves the total salary expenditure grouped by division.
     *
     * @return A Map where the key is the division and the value is the total pay for that division.
     * @throws SQLException If a database access error occurs.
     */
    public Map<String, Double> getTotalPayByDivision() throws SQLException {
        // SQL query to calculate total pay by division
        String query = "SELECT division, SUM(salary) AS total_pay FROM employees GROUP BY division";

        // Map to store the results (division -> total pay)
        Map<String, Double> results = new HashMap<>();

        // Use try-with-resources to handle database connection and statement
        try (Connection conn = DatabaseHelper.getConnection(); // Establish connection
             Statement stmt = conn.createStatement(); // Create a simple SQL statement
             ResultSet rs = stmt.executeQuery(query)) { // Execute the query and get the result set

            // Loop through the result set and populate the map
            while (rs.next()) {
                results.put(rs.getString("division"), rs.getDouble("total_pay"));
                // Add division as key and total pay as value to the map
            }
        }
        return results; // Return the map of divisions and their total pay
    }
}
