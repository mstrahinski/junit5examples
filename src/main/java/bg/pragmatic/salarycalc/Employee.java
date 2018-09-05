package bg.pragmatic.salarycalc;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private double height;
    private double weight;
    private BigDecimal salary;
    private int workHours;

    public Employee(String name, int age, double height, double weight, BigDecimal salary, int workHours) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.salary = salary;
        this.workHours = workHours;
    }

    public Employee(String name, int age, BigDecimal salary, int workHours) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workHours = workHours;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.height, height) == 0 &&
                Double.compare(employee.weight, weight) == 0 &&
                workHours == employee.workHours &&
                Objects.equals(name, employee.name) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, height, weight, salary, workHours);
    }
}
