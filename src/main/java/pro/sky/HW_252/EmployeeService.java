package pro.sky.HW_252;

import java.util.List;

public interface EmployeeService {
    int sumSalary();
    List<String> getFullNames();
    double averageSalary();
    int maxSalary();
    int minSalary();
    Employee addEmployee(String fullName, int salary);
    Employee removeEmployee(String fullName);
    public List<Employee> getEmployee();
    Employee changeEmployee(String fullName, int salary);
}

