package bg.pragmatic.salarycalc.repeatedtest;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class SalaryCalculatorRepeatedTest {

    @BeforeEach
    public void setup(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("Calculate a salary of 10 workhours, i.e. person with overtime")
    @RepeatedTest(value = 10, name = "{displayName} - {currentRepetition} of {totalRepetitions}")
    public void calculateRepeatTestWithMultipleWorkHours(RepetitionInfo repetitionInfo){
        SalaryCalculator calculator = new SalaryCalculator();
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), repetitionInfo.getCurrentRepetition() );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
    }
}
