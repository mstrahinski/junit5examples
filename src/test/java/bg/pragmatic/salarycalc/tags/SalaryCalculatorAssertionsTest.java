package bg.pragmatic.salarycalc.tags;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorAssertionsTest {

        private SalaryCalculator calculator = null;

        @BeforeEach
        void setup(){
            calculator = new SalaryCalculator(); // use these @BeforeSOMETHING methods to setup your fixtures and preconditions
        }

        @Test
        @Tag("regression")
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
        @Tag("sanity")
        @Tag("slow")
        public void calculateOvertimeSalary(){
            Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

            BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

            assertEquals(BigDecimal.valueOf(400), calculatedSalary, () -> { return "The salary was not correct"; });
        }

        @Test
        @Tag("slow")
        @Tag("sanity")
        public void checkingEmployeeValues() {
            Employee ivan = new Employee("Ivan Ivanov", 33, 1.88, 90, BigDecimal.valueOf(200), 8);


            assertNotNull(ivan);
            assertEquals(34, ivan.getAge()); // here it will FAIL and it will not continue with the next assertion, check the next test what you can do about it
            assertEquals(90, ivan.getWeight());
        }

}
