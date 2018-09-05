package bg.pragmatic.salarycalc.assertions;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorAssertionsTest {

        private SalaryCalculator calculator = null;

        @BeforeEach
        void setup(){
            calculator = new SalaryCalculator(); // use these @BeforeSOMETHING methods to setup your fixtures and preconditions
        }

        @Test
        public void calculateRegularSalary(){
            Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );

            BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

            assertEquals(BigDecimal.valueOf(200), calculatedSalary,
                    () -> {
                            System.out.println("Lazy loaded! The strings are only created if the test fails, that way it does not allocate memory");
                            return "The salary was not correct";
                    });
        }

        @Test
        public void calculateOvertimeSalary(){
            Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

            BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

            assertEquals(BigDecimal.valueOf(400), calculatedSalary, () -> { return "The salary was not correct"; });
        }

        @Test
        public void checkingEmployeeValues() {
            Employee ivan = new Employee("Ivan Ivanov", 33, 1.88, 90, BigDecimal.valueOf(200), 8);


            assertNotNull(ivan);
            assertEquals(34, ivan.getAge()); // here it will FAIL and it will not continue with the next assertion, check the next test what you can do about it
            assertEquals(90, ivan.getWeight());
        }

        @Test
        public void checkingEmployeeValuesWithAggregatedMultipleAssertions() {
            Employee ivan = new Employee("Ivan Ivanov", 33, 1.88, 90, BigDecimal.valueOf(200), 8);

            assertAll( "Checking multiple values of employee",
                    () -> assertNotNull(ivan),
                    () -> assertEquals(34, ivan.getAge()), //now when it FAILS it will continue to the next assertion and aggregate all the failures together if more than failure
                    () -> assertEquals(92, ivan.getWeight())
            );

        }

        @Test
        public void checkingEmployeeValuesAndAssertForTimeout() {
            Employee ivan = new Employee("Ivan Ivanov", 33, 1.88, 90, BigDecimal.valueOf(200), 8);

            //takes a duration of what to expect as how fast it should work as Duration object and invokes the lambda method
            // it fails if the execution of calculateSalary() took more than 1 ms and tells you how much time the whole execution took
            BigDecimal calculatedSalary = assertTimeout(Duration.ofMillis(1), () -> calculator.calculateSalary(ivan));

            // it fails if the execution of calculateSalary() took more than 1 ms and ABORTS the invocation if it took more than 1 milisecond, does not wait for the full execution
            BigDecimal otherCalculatedSalary = assertTimeoutPreemptively(Duration.ofMillis(1), () -> calculator.calculateSalary(ivan));

        }

}
