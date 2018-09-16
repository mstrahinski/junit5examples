package bg.pragmatic.salarycalc.annotated.interfaces;

import org.junit.jupiter.api.*;

public interface BaseTestInterface {

    @BeforeEach
    default void setup() {
        System.out.println("Before each in the interface");
    }

    @Test
    @DisplayName("Test in the interface")
    default void test(){
        System.out.println("Test in the interface");
    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all in the interface");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Before all in the interface");
    }
}
