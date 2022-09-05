package pro.sky.HW_252.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.HW_252.Employee;
import pro.sky.HW_252.Interface.DepartmentService;

import java.util.List;
import java.util.OptionalInt;

@RestController
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/departments/max-salary")
    public OptionalInt maxSalary(@RequestParam("department") int department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public OptionalInt minSalary(@RequestParam("department") int department) {
        return departmentService.minSalary(department);
    }

    @GetMapping("/departments/all")
    public List<Employee> allDepartment(@RequestParam("department") int department) {
        return departmentService.allDepartment(department);
    }

    @GetMapping("/department/all")
    public String all() {
        return departmentService.all();
    }
}
