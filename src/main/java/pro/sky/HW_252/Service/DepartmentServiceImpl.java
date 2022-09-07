package pro.sky.HW_252.Service;

import org.springframework.stereotype.Service;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Interface.DepartmentService;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int sumSalary() {

        return employeeService.employees.values().stream().mapToInt(Employee::getSalary).sum();

    }


    @Override
    public OptionalDouble averageSalary() {

        return employeeService.employees.values().stream().mapToInt(Employee::getSalary).average();
    }

    @Override
    public Employee maxSalary(int d) {

        return employeeService.employees.values().stream().filter(e->e.getDepartmentId()==d).max(Employee::compare).get();
    }

    @Override
    public Employee minSalary(int d) {

        return employeeService.employees.values().stream().filter(e->e.getDepartmentId()==d).min(Employee::compare).get();
    }

    @Override
    public List<Employee> allDepartment(int department) {
        return employeeService.employees.values().stream().filter(e -> e.getDepartmentId() == department).collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> all() {
        employeeService.addEmployee("Stas", 10,11);
        employeeService.addEmployee("Sarah", 12,11);
        employeeService.addEmployee("Hohn", 14,11);
        employeeService.addEmployee("Bob", 15,12);
        return  employeeService.employees.values().stream().collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
