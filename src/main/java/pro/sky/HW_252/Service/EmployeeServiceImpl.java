package pro.sky.HW_252.Service;

import org.apache.commons.lang3.StringUtils;
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
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        if (StringUtils.isEmpty(firstName)||StringUtils.isEmpty(lastName)) {
            throw new EmployeeAlreadyAddedException("400 Bad Request");
        }
        firstName=StringUtils.capitalize(firstName);
        lastName=StringUtils.capitalize(lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFirstName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.put(employee.getFirstName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fullName) {
        if (!StringUtils.isEmpty(fullName)) {
            throw new EmployeeAlreadyAddedException("400 Bad Request");
        }
        if (!employees.containsKey(fullName)) {
            throw new EmployeeNotFound("Такого сотрудника не существует");
        }
        return employees.remove(fullName);
    }

    @Override
    public Employee findEmployee(String fullName) {
        if (!StringUtils.isEmpty(fullName)) {
            throw new EmployeeAlreadyAddedException("400 Bad Request");
        }
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

