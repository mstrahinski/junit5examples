package bg.pragmatic.salarycalc.dynamictest;

import static org.junit.jupiter.api.Assertions.*;

import bg.pragmatic.salarycalc.Employee;
import bg.pragmatic.salarycalc.SalaryCalculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SalaryCalculatorDynamicTest {

    @BeforeEach
    public void thisMetodIsExecutedOnlyOnceNotForAllDynamicTests() {
        System.out.println("How many times we will see this message.");
    }

    @TestFactory
    public Collection<DynamicTest> dynamicTestFromACollection() {
        return Arrays.asList(
                dynamicTest("First dynamic test",
                        () -> {
                            assertEquals(1,1);
                        }),
                dynamicTest("Second dynamic test",
                        () -> {
                            assertEquals(3,2);
                        })
        );
    }

    @TestFactory
    public Iterable<DynamicTest> dynamicTestWithAnythingThatImplementsIterable() {
        return Arrays.asList(
                dynamicTest("First dynamic test",
                        () -> {
                            assertEquals(1,1);
                        }),
                dynamicTest("Second dynamic test",
                        () -> {
                            assertEquals(3,2);
                        })
        );
    }

    @TestFactory
    public Iterator<DynamicTest> dynamicTestWithIterator() {
        Iterator<DynamicTest> dynamicTestIterator = Arrays.asList(
                dynamicTest("First dynamic test",
                        () -> {
                            assertEquals(1, 1);
                        }),
                dynamicTest("Second dynamic test",
                        () -> {
                            assertEquals(3, 2);
                        })
        ).iterator();

        return dynamicTestIterator;
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestWithStream(){
        SalaryCalculator calculator = new SalaryCalculator();
        List<Employee> aWholeCompany = Arrays.asList(
                new Employee("Ivan", 10, BigDecimal.valueOf(500), 10),
                new Employee("Todor", 20, BigDecimal.valueOf(500), 10),
                new Employee("Maria", 30, BigDecimal.valueOf(500), 10),
                new Employee("Georgi", 40, BigDecimal.valueOf(500), 10),
                new Employee("Stefaniya", 50, BigDecimal.valueOf(500), 10)
        );

        return aWholeCompany.stream()
                .map(currentEmployee ->
                        dynamicTest("Test with: " + currentEmployee.getName(),
                                () -> {
                                    BigDecimal calculatedSalary = calculator.calculateSalary(currentEmployee);

                                    Assertions.assertEquals(BigDecimal.valueOf(1000), calculatedSalary);
                                }
                ));
    }

    @TestFactory
    public Stream<DynamicContainer> dynamicTestWithContainer() {
        SalaryCalculator calculator = new SalaryCalculator();
        List<Employee> aWholeCompany = Arrays.asList(
                new Employee("Ivan", 10, BigDecimal.valueOf(500), 10),
                new Employee("Todor", 20, BigDecimal.valueOf(500), 10),
                new Employee("Maria", 30, BigDecimal.valueOf(500), 10),
                new Employee("Georgi", 40, BigDecimal.valueOf(500), 10),
                new Employee("Stefaniya", 50, BigDecimal.valueOf(500), 10)
        );


        return aWholeCompany.stream()
                .map(currentEmployee ->
                    dynamicContainer("Dynamic container",
                        Stream.of(
                                dynamicTest("Is the employee age > 18, try with: " + currentEmployee.getName(),
                                        () -> assertTrue(currentEmployee.getAge() > 18, currentEmployee.getName() + " is less than 18 years old")

                                ),
                                dynamicContainer("Nested container",
                                        Stream.of(
                                                dynamicTest("Test if all employees receive doubled salary because of overtime",
                                                        () -> assertEquals(BigDecimal.valueOf(1000), calculator.calculateSalary(currentEmployee))
                                                )
                                        )
                                )

                         )
                    )
                );
    }

}
