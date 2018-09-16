package bg.pragmatic.salarycalc.parameterizedtest;

import bg.pragmatic.salarycalc.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryCalculatorParameterizedCsvFileSourceTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/names-and-workhours.csv")
    public void parameterizedTestWithCsvSource(String name, int workHours){
        Employee employee = new Employee(name, 20, BigDecimal.valueOf(200), workHours);

        assertEquals(name, employee.getName());
    }
}
