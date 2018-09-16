package bg.pragmatic.salarycalc.annotated.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SalaryCalculatorAnnotatedInterfaces implements BaseTestInterface {

    @Test
    @DisplayName("Test in the class")
    void testInTheClass(){
        System.out.println("Test in the class");
    }

    @Test
    @DisplayName("Other Test in the class")
    void otherTestInTheClass(){
        System.out.println("Test in the class");
    }
}
