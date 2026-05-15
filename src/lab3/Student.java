
package lab3;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String FormatieDeStudiu;
    private final float nota;

    public Student(int numarMatricol, String prenume, String nume, String FormatieDeStudiu, float nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.FormatieDeStudiu = FormatieDeStudiu;
        this.nota = nota;
    }


    public float getNota() {
        return nota;
    }

    public static Student schimbaFormatie(Student st, String nouaFormatie) {
        return new Student(
                st.getNumarMatricol(),
                st.getPrenume(),
                st.getNume(),
                nouaFormatie,
                st.getNota()
        );
    }

    @Override
    public String toString() {
        return numarMatricol + " " + prenume + " " + nume + " " + FormatieDeStudiu + " nota=" + nota;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return FormatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student s = (Student) o;
        return prenume.equals(s.prenume) &&
                nume.equals(s.nume) &&
                FormatieDeStudiu.equals(s.FormatieDeStudiu);
    }

    public int hashCode() {
        return prenume.hashCode() + nume.hashCode() + FormatieDeStudiu.hashCode();
    }

    public static boolean existaStudent(List<Student> lista, Student cautat) {
        for (Student s : lista) {
            if (s.getPrenume().equals(cautat.getPrenume()) &&
                    s.getNume().equals(cautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) ;
            return true;
        }
        return false;
    }

    //exercitiul3
    public static void main(String[] args) {
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70f),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90f),
                new Student(1029, "Bianca", "Popescu", "TI131/1,", 10f),
                new Student(1029, "Maria", "Pana", "TI131/2,", 4.10f),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2,", 7.33f),
                new Student(1029, "Marius", "Nasta", "TI131/2,", 3.20f),
                new Student(1029, "Marius", "Nasta", "TI131/1,", 5.12f),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2,", 2.22f)
        );
        //a
        System.out.println("a) Studenti cu nota 10:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(s -> System.out.println("   " + s));

        //b
        System.out.println("b) Studenti cu nota sub 5:");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(s -> System.out.println("   " + s));

        //c
        List<Student> listaModificata = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4) {
                        return new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), s.getFormatieDeStudiu(), 4.0f);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("c) Lista dupa ridicarea notelor sub 4 la nota 4:");
        listaModificata.forEach(s -> System.out.println("   " + s));

        //d
        float suma = 0f;
        for (Student s : studentiCuNote) {
            suma += s.getNota();
        }
        System.out.println("d) Suma notelor tuturor studentilor: " + suma);

        //e
        float medie = suma / studentiCuNote.size();
        System.out.printf("e) Media notelor: "  + medie);
        System.out.println("Laborator 10");


    }

}







