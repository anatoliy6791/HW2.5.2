package pro.sky.HW_252.Service;

import org.springframework.stereotype.Service;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Exception.EmployeeAlreadyAddedException;
import pro.sky.HW_252.Interface.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> employees = new HashMap();

    @Override
    public Employee addEmployee(String fullName, int salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
            if(employees.containsKey(employee.getFullName())){
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
        employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fullName) {
        Employee employee = employees.remove(fullName);
        if (employees == null){
            return employee;
        }
        throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
    }

    @Override
    public Employee findEmployee(String fullName) {
        Employee employee = employees.get(fullName);
        if (employees != null){
            return employee;
        }
        throw new EmployeeAlreadyAddedException("Такой сотрудник не найден");
    }

    @Override
    public Collection<Employee> getEmployee() {
        return Collections.unmodifiableCollection(employees.values());
    }
}

