package pro.sky.HW_252.Service;

import org.springframework.stereotype.Service;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Exception.EmployeeAlreadyAddedException;
import pro.sky.HW_252.Exception.EmployeeNotFound;
import pro.sky.HW_252.Interface.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final Map<String, Employee> employees = new HashMap();


    @Override
    public Employee addEmployee(String fullName, int salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFound("Такого сотрудника не существует");
        }
        return employees.remove(fullName);
    }

    @Override
    public Employee findEmployee(String fullName) {
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFound("Такого сотрудника не существует");
        }

        return employees.get(fullName);
    }

    @Override
    public Collection<Employee> getEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

