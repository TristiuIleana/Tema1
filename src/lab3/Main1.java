
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import lab4.Student;
import static lab4.Student.existaStudent;

public static void main(String[]  args) throws IOException  {
    Student student1 = new Student(615, "Ileana", "Tristiu", "21/1");
    System.out.println(student1);

    //Labortaor2 exercitiul1
    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    Random random = new Random();
    for (int i = 0; i < 8; i++) {
        x.add(random.nextInt(10));
    }
    for (int i = 0; i < 6; i++) {
        y.add(random.nextInt(10));
    }
    Collections.sort(x);
    Collections.sort(y);
    System.out.println("x = " + x);
    System.out.println("y = " + y);

    List<Integer> xPlusY = new ArrayList(); //a
    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("xPlusY = " + xPlusY);

    Set<Integer> zSet = new TreeSet(); //b
    for (Integer val : x) {
        if (y.contains(val)) {
            zSet.add(val);
        }
    }
    System.out.println("zSet = " + zSet);
    List<Integer> xMinusY = new ArrayList();//c
    for (Integer val : x) {
        if (!y.contains(val)) {
            xMinusY.add(val);
        }
    }
    System.out.println("xMinusY = " + xMinusY);

    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList();//d
    for (Integer val : xPlusY) {
        if (val <= p) {
            xPlusYLimitedByP.add(val);
        }
    }
    System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);

    //exercitiul2
    List<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(new Student(120, "Alis", "Popa", "TI21/2"));
    listaStudenti.add(new Student(112, "Maria", "Popa", "TI21/1"));
    System.out.println("Lista: ");
    for (Student s : listaStudenti) {
        System.out.println(s.toString());
    }

    Student s1 = new Student(120, "Alis", "Popa", "TI21/2");
    boolean gasit = existaStudent(listaStudenti, s1);
    System.out.println("Exista Alis Popa in lista " + gasit);

    Student s2 = new Student(112, "Maria", "Popa", "TI21/1");
    boolean gasit2 = existaStudent(listaStudenti, s2);
    System.out.println("Exista Maria Popa in lista " + gasit2);

    Set<Student> setStudenti = new HashSet<>(listaStudenti);
    System.out.println("Exista Alis Popa in lista " + setStudenti.contains(s1));
    System.out.println("Exista Maria Popa in lista " + setStudenti.contains(s2));

    //EXERCITIUL 3.5.2
    List<String> lines = Files.readAllLines(Paths.get("src/studenti_in.txt"));
    List<Student> studenti = new ArrayList<>();
    for (String line : lines) {
        String[] a = line.split(",");
        Student s = new Student(
                Integer.parseInt(a[0]),
                a[1],
                a[2],
                a[3]
        );
        studenti.add(s);
    }
    System.out.println("Studenti cititi:");
    for (Student s : studenti) {
        System.out.println(s);
    }
    studenti.sort(Comparator.comparing(Student::getNume));
    System.out.println("Sortarea noua: ");
    for (Student s : studenti) {
        System.out.println(s);
    }
    List<String> out = new ArrayList<>();
    for (Student s : studenti) {
        out.add(s.toString());
    }
    Files.write(Paths.get("src/studenti_out.txt"), out);

    //3.5.3
    studenti.sort(
            Comparator
                    .comparing(Student::getFormatieDeStudiu)
            .thenComparing(Student::getNume)
    );
    for (Student s : studenti) {
        System.out.println(s);
    }
    List<String> out2 = new ArrayList<>();
    for (Student s : studenti) {
        out2.add(s.toString());
    }
    Files.write(Paths.get("studenti_out_sorted.txt"), out2);


}
