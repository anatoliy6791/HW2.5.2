package pro.sky.HW_252.Interface;

import pro.sky.HW_252.Employee;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;


public interface DepartmentService {
    int sumSalary();

    OptionalDouble averageSalary();

    Employee maxSalary(int d);

    Employee minSalary(int d);

    List<Employee> allDepartment(int department);

    Map<Integer, List<Employee>> all();
}
