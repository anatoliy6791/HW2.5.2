package pro.sky.HW_252.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Interface.DepartmentService;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;

@RequestMapping ("/department")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("department") int department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping( "/min-salary")
    public Employee minSalary(@RequestParam("department") int department) {
        return departmentService.minSalary(department);
    }

    @GetMapping("/emps")
    public List<Employee> allDepartment(@RequestParam("department") int department) {
        return departmentService.allDepartment(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> all() {
        return departmentService.all();
    }
}
