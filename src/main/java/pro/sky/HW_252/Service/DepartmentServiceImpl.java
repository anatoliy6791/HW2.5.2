package pro.sky.HW_252.Service;

import org.springframework.stereotype.Service;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Interface.DepartmentService;


import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private EmployeeServiceImpl employeeService;

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
    public OptionalInt maxSalary(int d) {

        return employeeService.employees.values().stream().filter(e->e.getDepartmentId()==d).mapToInt(e -> e.getSalary()).max();
    }

    @Override
    public OptionalInt minSalary(int d) {

        return employeeService.employees.values().stream().filter(e->e.getDepartmentId()==d).mapToInt(e -> e.getSalary()).min();
    }

    @Override
    public List<Employee> allDepartment(int department) {
        return employeeService.employees.values().stream().filter(e -> e.getDepartmentId() == department).collect(Collectors.toList());
    }
    @Override
    public String all() {

        return employeeService.employees.values().toString();
    }
}
