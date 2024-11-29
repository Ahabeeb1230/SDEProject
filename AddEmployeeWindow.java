import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * GUI for adding a new employee.
 */
public class AddEmployeeWindow extends JFrame implements ActionListener {
    JTextField nameField, ssnField, jobTitleField, salaryField, divisionField;
    JButton submitButton;

    AddEmployeeWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(400, 400);

        // Input fields and labels
        this.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        this.add(nameField);

        this.add(new JLabel("SSN:"));
        ssnField = new JTextField(20);
        this.add(ssnField);

        this.add(new JLabel("Job Title:"));
        jobTitleField = new JTextField(20);
        this.add(jobTitleField);

        this.add(new JLabel("Division:"));
        divisionField = new JTextField(20);
        this.add(divisionField);

        this.add(new JLabel("Salary:"));
        salaryField = new JTextField(20);
        this.add(salaryField);

        submitButton = new JButton("Add Employee");
        submitButton.addActionListener(this);
        this.add(submitButton);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String name = nameField.getText();
                String ssn = ssnField.getText();
                String jobTitle = jobTitleField.getText();
                String division = divisionField.getText();
                double salary = Double.parseDouble(salaryField.getText());

                // Add the employee to the backend
                EmployeeMod.addEmployee(new Employee(name, ssn, jobTitle, division, salary));
                JOptionPane.showMessageDialog(this, "Employee Added Successfully!");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }
}
