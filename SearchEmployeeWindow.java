import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

/**
 * GUI for searching employees by name, SSN, or ID.
 */
public class SearchEmployeeWindow extends JFrame implements ActionListener {
    JTextField searchField;
    JButton searchButton;

    SearchEmployeeWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 200);

        // Search input and button
        this.add(new JLabel("Search by Name, SSN, or Employee ID:"));
        searchField = new JTextField(20);
        this.add(searchField);

        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        this.add(searchButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String query = searchField.getText();
            List<Employee> results = EmployeeMod.searchEmployees(query);

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No employees found matching the query.");
            } else {
                StringBuilder resultMessage = new StringBuilder("Search Results:\n");
                for (Employee emp : results) {
                    resultMessage.append(emp).append("\n");
                }
                JOptionPane.showMessageDialog(this, resultMessage.toString());
            }
        }
    }
}
