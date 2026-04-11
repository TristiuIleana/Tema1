package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import advanced.DoubleCalculator;
public class DoubleCalculatorTest {
    @Test
    public void testAdd() {
        DoubleCalculator calc = new DoubleCalculator().init();
        Assertions.assertEquals(5.0, calc.add(2.0).add(3.0).result());
    }

    @Test
    public void testSubtract() {
        DoubleCalculator calc = new DoubleCalculator().init();
        Assertions.assertEquals(2.0, calc.add(5.0).subtract(3.0).result());
    }

    @Test
    public void testMultiply() {
        DoubleCalculator calc = new DoubleCalculator().init();
        Assertions.assertEquals(6.0, calc.add(2.0).multiply(3.0).result());
    }

    @Test
    public void testChain() {
        DoubleCalculator calc = new DoubleCalculator().init();
        Assertions.assertEquals(10.0, calc.add(2.0).add(3.0).multiply(2.0).result());
    }
}
//