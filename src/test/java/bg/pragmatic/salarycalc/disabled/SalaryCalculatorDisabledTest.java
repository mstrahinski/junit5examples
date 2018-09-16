package bg.pragmatic.salarycalc.disabled;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import java.math.BigDecimal;

import static org.junit.jupiter.api.condition.OS.*;

//@Disabled("Expecting some changes/optimizations, we DO NOT want the tests in this class to be run for now")
public class SalaryCalculatorDisabledTest {

    @DisplayName("Calculate a salary of an 8 hours working person")
    @Test
    public void calculateRegularSalary(){
        SalaryCalculator calculator = new SalaryCalculator();
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(200), calculatedSalary, "The salary was not correct");
    }

    @DisplayName("Calculate a salary of an 10 hours, i.e. person with overtime")
    @Test
    @Disabled("Expecting some changes, we dont want this test to be run for now")
    @DisabledOnOs({ WINDOWS, MAC })
    public void calculateOvertimeSalary(){
        SalaryCalculator calculator = new SalaryCalculator();
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
    }
}
