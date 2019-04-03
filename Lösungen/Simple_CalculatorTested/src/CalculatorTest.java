import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class CalculatorTest {

	@BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

	@Test
	void testAdd() {
		assertEquals(5, Calculator.add(3, 2));
	}
	@Test
	void testSubtract()
	{
		assertEquals(1, Calculator.subtract(3, 2));
	}
	@Test
	void testDivide() throws Exception {
		assertEquals(2.5, Calculator.divide(5, 2));
	}
	@Test
	void testMultiply() {
		assertEquals(6, Calculator.multiply(3, 2));
	}
	@Test() 
	void testDevisionByZero() {
		Throwable exception = assertThrows(CalculationException.class, () -> {
            Calculator.divide(2, 0);
        });
        assertEquals(">> Error: teilen durch 0!", exception.getMessage());
	}
	@Test
	void testInvalidOperation() {
		assertThrows(OperationUnknownException.class, () -> {
			Calculator.performOperation(1, 1, "#");
		});
	}
	
	@AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
