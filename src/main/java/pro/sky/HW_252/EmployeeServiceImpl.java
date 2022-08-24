package pro.sky.HW_252;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();
    int id = 0;





    @Override
    public Employee addEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName,salary);
        employees.add(employee);
        id++;
        return employee;
    }

    @Override
    public Employee removeEmployee(String fullName) {
        for(int i = 0; i < employees.size(); i++){
            if(fullName.equals(employees.get(i).getFullName())){
                employees.remove(i);
            }
        }
        return null;
    }
    @Override
    public Employee changeEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName,salary);
        for(int i = 0; i < employees.size(); i++){
            if(fullName.equals(employees.get(i).getFullName())
                    &salary==employees.get(i).getSalary()){
                employee=employees.get(i);
            }

        }

        return employee;
    }

    @Override
    public List<Employee> getEmployee() {
        return employees;
    }


    @Override
    public int sumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    @Override
    public List<String> getFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
        return getFullNames();
    }


    @Override
    public double averageSalary() {
        double average = (sumSalary() / employees.size());
        return average;
    }

    @Override
    public int maxSalary() {
        List<String> list = new ArrayList<>();
        int max = employees.get(0).getSalary();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary() > max) {
                max = employees.get(i).getSalary();

            }
        }
        return max;
    }

    @Override
    public int minSalary() {
        int min = employees.get(0).getSalary();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSalary() < min) {
                min = employees.get(i).getSalary();

            }
        }
        return min;
    }
}

