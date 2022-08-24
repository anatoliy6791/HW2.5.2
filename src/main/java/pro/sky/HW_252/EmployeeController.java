package pro.sky.HW_252;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployee();
    }

    @GetMapping("/sum")
    public int sum() {
        return employeeService.sumSalary();
    }

    @GetMapping("/average")
    public double average() {
        return employeeService.averageSalary();
    }

    @GetMapping("/max")
    public double max() {
        return employeeService.maxSalary();
    }

    @GetMapping("/min")
    public double min() {
        return employeeService.minSalary();
    }

    @GetMapping("/employee/change")
    public Employee updateEmployee(@RequestParam int id) {
        return employeeService.changeEmployee(id);
    }

    @GetMapping("/employee/delete")
    public String removeEmployee(@RequestParam("id") int id) {
        return employeeService.removeEmployee(id);
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("salary") int salary) {
        return employeeService.addEmployee(name, salary);
    }


}
