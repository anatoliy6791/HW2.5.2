package pro.sky.HW_252;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/employee")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployee();
    }


    @GetMapping("/employee/change")
    public Employee updateEmployee(@RequestParam String fullName) {
        return employeeService.findEmployee(fullName);
    }

    @GetMapping("/employee/delete")
    public Employee removeEmployee(@RequestParam("fullName") String fullName) {
        return employeeService.removeEmployee(fullName);
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("salary") int salary) {
        return employeeService.addEmployee(name, salary);
    }


}
