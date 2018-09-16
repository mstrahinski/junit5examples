package bg.pragmatic.salarycalc.parameterizedtest;

import bg.pragmatic.salarycalc.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryCalculatorParameterizedEnumSourceTest {


    @ParameterizedTest
    @EnumSource(value = EmployeeNames.class)
    public void parameterizedWithEnumSource(EmployeeNames employeeName){
        Employee employee = new Employee(employeeName.getEmployeeName(), 20, BigDecimal.valueOf(200), 10);

        assertEquals(employeeName.getEmployeeName(), employee.getName());
    }

    @ParameterizedTest
    @EnumSource(value = EmployeeNames.class, names = {"GEORGI", "BOJINKATA"})
    public void parameterizedWithEnumSourceWithPartOfTheEnum(EmployeeNames employeeName){
        Employee employee = new Employee(employeeName.getEmployeeName(), 20, BigDecimal.valueOf(200), 10);

        assertEquals(employeeName.getEmployeeName(), employee.getName());
    }

    @ParameterizedTest
    @EnumSource(value = EmployeeNames.class, names = {"GEORGI", "BOJINKATA"}, mode = EnumSource.Mode.EXCLUDE)
    public void parameterizedWithEnumSourceWithPartOfTheEnumExclusively(EmployeeNames employeeName){
        Employee employee = new Employee(employeeName.getEmployeeName(), 20, BigDecimal.valueOf(200), 10);

        assertEquals(employeeName.getEmployeeName(), employee.getName());
    }

    @ParameterizedTest
    @EnumSource(value = EmployeeNames.class, names = "^MAR.*", mode = EnumSource.Mode.MATCH_ALL)
    public void parameterizedWithEnumSourceWithPartOfTheEnumRegExMatcher(EmployeeNames employeeName){
        Employee employee = new Employee(employeeName.getEmployeeName(), 20, BigDecimal.valueOf(200), 10);

        assertEquals(employeeName.getEmployeeName(), employee.getName());
    }

}
