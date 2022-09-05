package pro.sky.HW_252.Interface;

import pro.sky.HW_252.Employee;

import java.util.Collection;

public interface EmployeeService {
    // int sumSalary();
    // List<String> getFullNames();
    // double averageSalary();
    // int maxSalary();
    // int minSalary();
    // Employee addEmployee(Integer key, String fullName, int salary);

   // Employee removeEmployee(String fullName,int salary);



    Employee addEmployee(String fullName, int salary, int department);

    Employee removeEmployee(String fullName);

    Employee findEmployee(String fullName);

    Collection<Employee> getEmployee();
   // Employee changeEmployee(String fullName,int salary);
}

