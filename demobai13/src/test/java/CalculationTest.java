import junit.framework.TestCase;

public class CalculationTest extends TestCase {

    private Calculation calculation;
    public void setUp() throws Exception {
        super.setUp();
        System.out.printf("\nstart unit test");
        calculation = new Calculation();
    }

    public void tearDown() throws Exception {
        System.out.print("\nfinish unit test");
    }

    public void testSum() {
        int result = calculation.sum(3,6);
        assertEquals(9,result);
    }

}