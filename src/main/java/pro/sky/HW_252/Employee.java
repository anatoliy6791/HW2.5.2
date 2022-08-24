package pro.sky.HW_252;

public class Employee {
    private String fullName;
    private int salary;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Employee(String fullName, int salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
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