
package lab4;

import java.util.List;

public class Student {
    private int numarMatricol;
    private String prenume;
    private String nume;
    private String FormatieDeStudiu;
    private float nota;

    public Student(int numarMatricol, String prenume, String nume, String FormatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.FormatieDeStudiu = FormatieDeStudiu;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
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
}