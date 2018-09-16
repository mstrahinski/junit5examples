package bg.pragmatic.salarycalc.parameterizedtest;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

public class SalaryCalculatorParameterizedValueSourceTest {
    private SalaryCalculator calculator;

    @BeforeEach
    public void setup(TestInfo testInfo){
        System.out.println("Running test: " + testInfo.getDisplayName());
        calculator = new SalaryCalculator();
    }

    @DisplayName("ParametrizedTest Container Display Name")
    @ParameterizedTest
    @ValueSource(ints = {20,6,40,50,10})
    public void parameterizedTestSalariesOfOvertimeEmployee(int workHours){
        Employee employee = new Employee("Ivan", 20, BigDecimal.valueOf(200), workHours);
        BigDecimal calculatedSalary = calculator.calculateSalary(employee);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary);
    }

    @ParameterizedTest(name = "Test No.{index} : workHours={0}")
    @ValueSource(ints = {20,6,40,50,10})
    public void parameterizedTestEachTestWithDifferentName(int workHours){
        Employee employee = new Employee("Ivan", 20, BigDecimal.valueOf(200), workHours);
        BigDecimal calculatedSalary = calculator.calculateSalary(employee);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary);
    }

    @ParameterizedTest(name = "Test No.{index} : workHours={0}")
    @ValueSource(ints = {20,6,40,50,10})
    public void parameterizedTestWithInjectedTestReporterAndTestInfo(int workHours, TestInfo testInfo, TestReporter testReporter){
//        System.out.println(testInfo.getDisplayName());   // this can also be injected into lifecycle methods like @BeforeEach
//        testReporter.publishEntry("WorkHours: " + workHours);

        Employee employee = new Employee("Ivan", 20, BigDecimal.valueOf(200), workHours);
        BigDecimal calculatedSalary = calculator.calculateSalary(employee);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary);
    }



}
