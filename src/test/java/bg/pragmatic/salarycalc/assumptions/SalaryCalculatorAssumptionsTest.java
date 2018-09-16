package bg.pragmatic.salarycalc.assumptions;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.*;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class SalaryCalculatorAssumptionsTest {
    SalaryCalculator calculator;

    @BeforeEach
    void setup(){
        calculator = new SalaryCalculator();
        //if you put it in the @BeforeEach it will skip all the tests if we're not on Linux
        //assumeTrue(SystemUtils.IS_OS_LINUX);
    }

    @Test
    void calculateOvertimeSalary(){
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        // this assert WILL happen
        assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");

        assumeTrue(SystemUtils.IS_OS_LINUX);

        // the following three asserts WILL NOT happen as the assumption is not met as I'm on Windows
        assertEquals("Ivan", ivan.getName());
        assertEquals(20, ivan.getAge());
        assertEquals(10, ivan.getWorkHours());
    }

    @Test
    void calculateRegularSalary(){
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        //executes the assertion ONLY if the assumption is TRUE
        assumingThat(SystemUtils.IS_OS_LINUX, () -> {
            assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
        });

        assertEquals("Ivan", ivan.getName());
        assertEquals(20, ivan.getAge());
        assertEquals(8, ivan.getWorkHours());
    }
}
