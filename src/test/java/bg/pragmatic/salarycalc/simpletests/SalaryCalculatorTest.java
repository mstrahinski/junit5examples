package bg.pragmatic.salarycalc.simpletests;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SalaryCalculatorTest {

    @Test
    public void calculateRegularSalary(){
        SalaryCalculator calculator = new SalaryCalculator();
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(200), calculatedSalary, "The salary was not correct");
    }

    @Test
    public void calculateOvertimeSalary(){
        SalaryCalculator calculator = new SalaryCalculator();
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
    }
}
