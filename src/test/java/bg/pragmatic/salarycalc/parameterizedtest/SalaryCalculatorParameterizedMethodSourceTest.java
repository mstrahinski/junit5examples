package bg.pragmatic.salarycalc.parameterizedtest;

import bg.pragmatic.salarycalc.Employee;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class SalaryCalculatorParameterizedMethodSourceTest {


    @ParameterizedTest
    @MethodSource("allWorkHours")
    public void parameterizedTestWithMethodSource(String name, int workHours){
        Employee employee = new Employee(name, 20, BigDecimal.valueOf(200), workHours);

        assertEquals(name, employee.getName());
    }

    private static Stream<String> allEmployeeNames() {
        return Stream.of("Ivan", "Nikoleri", "Georgi", "Maria");
    }

    private static Stream<Arguments> allWorkHours() {
        return allEmployeeNames().map(employeeName -> Arguments.of(employeeName, 10));
    }

}
