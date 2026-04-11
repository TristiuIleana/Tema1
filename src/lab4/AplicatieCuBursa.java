package lab4;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import lab4.Student;

public class AplicatieCuBursa {
    static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        System.out.println("--------------------------------------------------");
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70f, 725.50));
        lista.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80f, 801.10));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 780.80));
        lista.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90f, 745.50));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1,", 9.10f, 100.00));
        return lista;

    }
    public List<StudentBursier> sorteaza(List<StudentBursier> lista) {
        lista.sort(
                Comparator
                        .comparing(StudentBursier::getNota).reversed()
                        .thenComparing(StudentBursier::getNume)
        );
        return lista;
    }
}