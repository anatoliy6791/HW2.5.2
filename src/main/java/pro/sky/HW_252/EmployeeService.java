package pro.sky.HW_252;

import java.util.List;

public interface EmployeeService {
    int sumSalary();
    List<String> getFullNames();
    double averageSalary();
    int maxSalary();
    int minSalary();
    Employee addEmployee(String fullName, int salary);
    String removeEmployee(int id);
    public List<Employee> getEmployee();
    Employee changeEmployee(int id);
}

