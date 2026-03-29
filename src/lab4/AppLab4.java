package lab4;
import java.io.File;
import java.util.*;
import java.util.Scanner;

//4.5.1
public class AppLab4 {
    static void main(String[] args) {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        System.out.println("Varsta: ");
        varste.forEach((k, v) -> System.out.println(k + " -> " + v));
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println("Dupa adaugare: ");
        varste.forEach((k, v) -> System.out.println(k + " -> " + v));
        Map<String, String> adrese = Map.of("Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );
        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.getOrDefault(nume, "Necunoscut");
            Tanar t = new Tanar(nume, varsta, adresa);
            tineri.put(nume, t);
        }
        System.out.println("Lista tineri: ");
        tineri.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}
