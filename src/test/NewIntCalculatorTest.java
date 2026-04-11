package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import calculator.IntCalculator;

public class NewIntCalculatorTest {
    @Test
    public void testAddPositive() {
        IntCalculator calc = new IntCalculator();
        Assertions.assertEquals(5, calc.add(2).add(3).result());
    }

    @Test
    public void testAddNegatives() {
        IntCalculator calc = new IntCalculator();
        Assertions.assertEquals(-5, calc.add(-2).add(-3).result());
    }

    @Test
    public void testSubtractPositives() {
        IntCalculator calc = new IntCalculator(5);
        Assertions.assertEquals(2, calc.subtract(3).result());
    }

    @Test
    public void testSubtractNegatives() {
        IntCalculator calc = new IntCalculator(-5);
        Assertions.assertEquals(-2, calc.subtract(-3).result());
    }

    @Test
    public void testMultiplyPositives() {
        IntCalculator calc = new IntCalculator(2);
        Assertions.assertEquals(6, calc.multiply(3).result());
    }

    @Test
    public void testMultiplyNegatives() {
        IntCalculator calc = new IntCalculator(-2);
        Assertions.assertEquals(6, calc.multiply(-3).result());
    }

    @Test
    public void testMultiplyBy0() {
        IntCalculator calc = new IntCalculator(5);
        Assertions.assertEquals(0, calc.multiply(0).result());
    }

    @Test
    public void testChainOperations() {
        IntCalculator calc = new IntCalculator(5);
        Assertions.assertEquals(12, calc.add(3).multiply(2).subtract(4).result());
    }

    @Test
    public void testInitialValue() {
        IntCalculator calc = new IntCalculator(10);
        Assertions.assertEquals(10, calc.result());
    }

}
