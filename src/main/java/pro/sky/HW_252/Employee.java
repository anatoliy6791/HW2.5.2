package pro.sky.HW_252;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private int departmentId;



    public int getDepartmentId() {
        return departmentId;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.firstName= firstName;
        this.lastName=lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public int hashCode() {
        return firstName.hashCode()*lastName.hashCode()*salary+13;
    }


    public boolean equals(Employee employee) {
        return this.salary == employee.salary;
    }

}