package lab9;
import java.util.*;
import java.util.stream.*;
import java.util.Random;

public class MainLab9 {
    public static void main(String[] args){
        Random random = new Random();
        System.out.println("Exercitiul 1: ");
        //lista
        List<Integer> numere = IntStream.range(0,10)
        .map(i -> 5 + random.nextInt(21)) // [5, 25]
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista: " + numere);

        //a
        int suma = numere.stream()
                .reduce(0, Integer::sum);
        System.out.println("Suma numerelor: " + suma);

        //b
        int max = numere.stream()
                .max(Comparator.naturalOrder())
                .get();
        int min = numere.stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println("Maxim: " + max);
        System.out.println("Minim: " + min);

        //c
        List<Integer> filtrare = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Numerele din interval: " + filtrare);

        //d
        List<Double> doubles = numere.stream()
                .map(n -> n.doubleValue())
                .collect(Collectors.toList());
        System.out.println("Lista transformata in Double: " + doubles);

        //e
        boolean contine12 = numere.stream()
                .anyMatch(n -> n == 12);
        System.out.println("Lista contine val. 12: " + contine12);
    }
}
