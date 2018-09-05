package bg.pragmatic.salarycalc.hierarchies;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@DisplayName("Salary Calculator Test")
public class SalaryCalculatorHierarchiesTest {

    private SalaryCalculator calculator = null;

    @BeforeEach
    void setup(){
        calculator = new SalaryCalculator();
    }

    @DisplayName("Overtimer")
    @Nested
    class OvertimeEmployee {
        private Employee ivan = null;

        @BeforeEach
        void setup(){
            ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );
        }

        @DisplayName("When I calculate his salary - it should be doubled, i.e. 400")
        @Test
        public void calculateOvertimeSalary(){
            BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

            Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
        }
    }

    @DisplayName("No overtimer")
    @Nested
    class NoOvertimeEmployee {
        private Employee ivan = null;

        @BeforeEach
        void setup(){
            ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );
        }

        @DisplayName("When I calculate his salary - it should be normal, i.e. 200")
        @Test
        void calculateRegularSalary(){
            BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

            Assertions.assertEquals(BigDecimal.valueOf(200), calculatedSalary, "The salary was not correct");
        }
    }
}
