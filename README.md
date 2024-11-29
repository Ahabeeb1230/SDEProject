1. Core Classes
   
Employee:

Represents individual employee records.
Stores attributes like empId, name, ssn, jobTitle, division, and salary.
Provides methods for comparing attributes (matches) and formatting details (toString).


EmployeeMod:
Acts as the data layer, managing a centralized List<Employee>.
Provides methods to:
Add, search, update, delete employees.
Perform operations like salary adjustments.
Centralizes all employee-related data, ensuring consistency across the system.

Reporting:
Provides methods to generate reports using data from EmployeeMod.
Examples of reports:
Full-time employee information.
Total pay grouped by job title or division.

2. GUI Classes

MainMenu:
The main navigation window for the application.
Provides buttons for different functionalities: adding employees, searching, updating, and generating reports.

AddEmployeeWindow:
A form-based window for adding a new employee.
Takes user input, validates it, and adds the employee to the system via EmployeeMod.addEmployee().

SearchEmployeeWindow:
Allows searching for employees using a query (name, SSN, or ID).
Displays results from EmployeeMod.searchEmployees() in a dialog box.

UpdateEmployeeWindow:
Handles both employee detail updates and salary adjustments.
Uses EmployeeMod.updateEmployee() for updates and EmployeeMod.updateSalary() for salary changes.

ReportWindow:
Generates reports using methods in the Reporting class.
Displays results in a scrollable text area.

