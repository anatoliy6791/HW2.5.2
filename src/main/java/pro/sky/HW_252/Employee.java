package pro.sky.HW_252;

public class Employee {
    private int id;
    private String fullName;
    private int salary;
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String fullName, int salary, int departmentId) {
        this.fullName = fullName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return fullName;
    }

public static int compare(Employee employee, Employee employee1) {
    if (employee.getSalary() > employee1.getSalary()) {
        return 1;
    }
    return -1;
}

    public int getSalary() {
        return salary;
    }



    public int setSalary(int salary) {
        return salary;
    }


    @Override
    public int hashCode() {
        return fullName.hashCode()*salary+13;
    }


    public boolean equals(Employee employee) {
        return this.salary == employee.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }
}