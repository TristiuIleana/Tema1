
package lab3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    //public void setNota(float nota) {
       // this.nota = nota;
    //}

    public float getNota() {
        return nota;
    }
    public static Student schimbaFormatie(Student st, String nouaFormatie){
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

    public int getNumarMatricol(){
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
}
a
