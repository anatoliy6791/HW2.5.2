package pro.sky.HW_252;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();


    @Override
    public Employee addEmployee(String fullName, int salary) {
        Employee employee = new Employee(fullName, salary);
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getFullName().equals(fullName)
                    && employees.get(i).getSalary()==salary){
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
        }
        if (employees.size() == 0) {
            employee.setId(1);
        } else {
            employee.setId(employees.size() + 1);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public String removeEmployee(int id) {
        if (employees.size()<id-1 || id<=0){
            throw new EmployeeNotFound("работника c ID"+" "+ id + " " + "нет в списке");
        }
        employees.remove(id - 1);
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getId()!=1)
            employees.get(i).setId(employees.get(i).getId() - 1);
        }
        return "Работник удален";
    }

    @Override
    public Employee changeEmployee(int id) {
        if (employees.size()<id-1 || id<=0){
            throw new EmployeeNotFound("работника c ID"+" "+ id + " " + "нет в списке");
        }
        return employees.get(id-1);
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

