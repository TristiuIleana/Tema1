package lab3;

import java.util.List;

public class StudentiInConsola implements IStudentiExport{
        public void doExport(List<Student> studenti) {
            System.out.println("Lista studenti ");
            for (Student s : studenti) {
                System.out.println(s.getNumarMatricol() + " " + s.getPrenume() + " "
                        + s.getNume() + " " + s.getFormatieDeStudiu() + " nota=" + s.getNota());
            }
            System.out.println("Total: " + studenti.size() + " studenti");
        }
    }

