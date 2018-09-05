package bg.pragmatic.salarycalc.lifecycle.annotation.and.executions;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD) // this is the default behavior, rather you type it or not
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SalaryCalculatorLifecycleTest {

    private SalaryCalculator calculator = null;

    public SalaryCalculatorLifecycleTest() {
        System.out.println("Constructor - invoked!");
    }

    @BeforeAll
    static void setupAll() {
        System.out.println("@BeforeAll - invoked!");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("@AfterAll - invoked!");
    }

    @BeforeEach
    void setup(){
        System.out.println("@BeforeEach - invoked");

        calculator = new SalaryCalculator(); // use these @BeforeSOMETHING methods to setup your fixtures and preconditions

    }

    @AfterEach
    void tearDown(){
        System.out.println("@AfterEach - invoked");
    }

    @Test
    public void calculateRegularSalary(){
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 8 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(200), calculatedSalary, "The salary was not correct");
    }

    @Test
    public void calculateOvertimeSalary(){
        Employee ivan = new Employee("Ivan", 20, BigDecimal.valueOf(200), 10 );

        BigDecimal calculatedSalary = calculator.calculateSalary(ivan);

        Assertions.assertEquals(BigDecimal.valueOf(400), calculatedSalary, "The salary was not correct");
    }
}
