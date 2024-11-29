import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * GUI for updating employee details and adjusting salaries.
 */
public class UpdateEmployeeWindow extends JFrame implements ActionListener {
    JTextField searchField, newNameField, newDivisionField, percentageField, minSalaryField, maxSalaryField;
    JButton searchButton, updateDetailsButton, updateSalaryButton;
    Employee selectedEmployee = null;

    UpdateEmployeeWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(500, 400);

        // Search and update components
        this.add(new JLabel("Search by Name, SSN, or Employee ID:"));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        this.add(searchField);
        this.add(searchButton);

        this.add(new JLabel("New Name:"));
        newNameField = new JTextField(20);
        this.add(newNameField);

        this.add(new JLabel("New Division:"));
        newDivisionField = new JTextField(20);
        this.add(newDivisionField);

        updateDetailsButton = new JButton("Update Details");
        updateDetailsButton.addActionListener(this);
        this.add(updateDetailsButton);

        this.add(new JLabel("Increase Salary by (%) for Range:"));
        percentageField = new JTextField(5);
        minSalaryField = new JTextField(10);
        maxSalaryField = new JTextField(10);
        this.add(new JLabel("Min Salary:"));
        this.add(minSalaryField);
        this.add(new JLabel("Max Salary:"));
        this.add(maxSalaryField);
        this.add(new JLabel("Percentage:"));
        this.add(percentageField);

        updateSalaryButton = new JButton("Update Salaries");
        updateSalaryButton.addActionListener(this);
        this.add(updateSalaryButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) { 
            // Search for the employee
            String query = searchField.getText();
            for (Employee emp : EmployeeMod.searchEmployees(query)) {
                if (emp.matches(query)) {
                    selectedEmployee = emp;
                    JOptionPane.showMessageDialog(this, "Employee Found:\n" + emp.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No matching employee found!");
        } else if (e.getSource() == updateDetailsButton) {
            if (selectedEmployee != null) {
                String newName = newNameField.getText();
                String newDivision = newDivisionField.getText();

                // Update employee details
                boolean success = EmployeeMod.updateEmployee(
                    selectedEmployee.getEmpId(),
                    newName,
                    newDivision
                );

                if (success) {
                    JOptionPane.showMessageDialog(this, "Employee details updated:\n" + selectedEmployee.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "Error updating employee details.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Search for an employee first!");
            }
        } else if (e.getSource() == updateSalaryButton) {
            try {
                double minSalary = Double.parseDouble(minSalaryField.getText());
                double maxSalary = Double.parseDouble(maxSalaryField.getText());
                double percentageIncrease = Double.parseDouble(percentageField.getText());

                // Update salaries for employees in the specified range
                EmployeeMod.updateSalary(minSalary, maxSalary, percentageIncrease);
                JOptionPane.showMessageDialog(this, "Salaries updated for the specified range!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
            }
        }
    }
}

