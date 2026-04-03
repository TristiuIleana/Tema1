package lab5;

import lab5.advanced.DoubleCalculator;
import lab5.advanced.NewIntCalculator;

public class AppLab5 {
    public static void main(String[] args){
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();

        AdvancedCalculator advancedCalculator = new AdvancedCalculator(10);
        int result2 = advancedCalculator.divide(4).power(2).root(2).result();
        System.out.println("b) " + result2);

        NewIntCalculator calc = new NewIntCalculator(10);
        int result3 = (Integer) calc.add(5).subtract(3).multiply(2).result();
        System.out.println("ex2 a)" + result3);

        DoubleCalculator dcalc = new DoubleCalculator(10);
        double result4 = (Double) dcalc.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("b)" + result4);
    }
}
