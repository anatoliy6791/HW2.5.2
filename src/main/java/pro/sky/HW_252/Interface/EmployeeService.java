package pro.sky.HW_252.Interface;

import pro.sky.HW_252.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String fullName, int salary, int department);


    Employee removeEmployee(String fullName);

    Employee findEmployee(String fullName);

    Collection<Employee> getEmployee();

}

