package lab5;
import java.util.HashSet;
import  java.util.Set;

import jdk.jshell.execution.Util;
import lab4.ScriereFisier;
import lab4.StudentBursier;
import lab5.advanced.DoubleCalculator;
import lab5.advanced.NewIntCalculator;

public class AppLab5 {
    public static void main(String[] args) {
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

        Set<StudentBursier> bursieri = new HashSet<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 780.80));
        ScriereFisier.writeToFile("bursieri_out.txt", bursieri);
    }
}
