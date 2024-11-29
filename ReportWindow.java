import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

/**
 * GUI for generating employee reports.
 */
public class ReportWindow extends JFrame implements ActionListener {
    JButton fullTimeReportButton, payByTitleButton, payByDivisionButton;
    JTextArea reportArea;

    ReportWindow() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(600, 500);

        // Report display area
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);

        // Report buttons
        fullTimeReportButton = new JButton("Full-Time Employee Info");
        payByTitleButton = new JButton("Total Pay by Job Title");
        payByDivisionButton = new JButton("Total Pay by Division");

        fullTimeReportButton.addActionListener(this);
        payByTitleButton.addActionListener(this);
        payByDivisionButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(fullTimeReportButton);
        buttonPanel.add(payByTitleButton);
        buttonPanel.add(payByDivisionButton);

        this.add(new JLabel("Employee Reports", SwingConstants.CENTER), BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fullTimeReportButton) {
            String report = Reporting.generateFullTimeEmployeeReport();
            reportArea.setText(report);
        } else if (e.getSource() == payByTitleButton) {
            Map<String, Double> payByTitle = Reporting.getTotalPayByJobTitle();
            StringBuilder report = new StringBuilder("Total Pay by Job Title:\n");
            report.append("--------------------------------------------------\n");
            for (Map.Entry<String, Double> entry : payByTitle.entrySet()) {
                report.append("Job Title: ").append(entry.getKey())
                      .append(", Total Pay: $").append(entry.getValue()).append("\n");
            }
            reportArea.setText(report.toString());
        } else if (e.getSource() == payByDivisionButton) {
            Map<String, Double> payByDivision = Reporting.getTotalPayByDivision();
            StringBuilder report = new StringBuilder("Total Pay by Division:\n");
            report.append("--------------------------------------------------\n");
            for (Map.Entry<String, Double> entry : payByDivision.entrySet()) {
                report.append("Division: ").append(entry.getKey())
                      .append(", Total Pay: $").append(entry.getValue()).append("\n");
            }
            reportArea.setText(report.toString());
        }
    }
}
