import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import lab4.Student;

public static void main(String[]  args) throws IOException {

    //4.5.2
    System.out.println("ex2");
    HashMap<Integer, Student> studentHashMap = new HashMap<>();
    try {
        File f = new File("src/lab4/Student.txt");
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");
            int nr = Integer.parseInt(parts[0]);
            String prenume = parts[1];
            String nume = parts[2];
            String grupa = parts[3];
            studentHashMap.put(nr, new Student(nr, prenume, nume, grupa));
        }
        sc.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    try {

        Path caleFisier = Paths.get("src/lab4/note_anon.txt");
        List<String> line = Files.readAllLines(caleFisier);
        for(String citirelinie: line){
            String[] parts = citirelinie.split(",");
            if(parts.length >= 2){
                int nr = Integer.parseInt(parts[0]);
                float nota = Float.parseFloat(parts[1]);
                Student s = studentHashMap.get(nr);
                if (s != null) {
                    s.setNota(nota);
                     }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("nr stydenti:" + studentHashMap.size());
    System.out.println("Studenti cu nota: ");
    studentHashMap.values().forEach(s -> System.out.println(s));

    HashMap<Integer, Student> studenti = new HashMap<>();
     HashMap<String, Student> mapNume = new HashMap<>();
    for(Student s:studenti.values()){
        String key = s.getPrenume() + "-" + s.getNume();
        mapNume.put(key,s);
    }
    Student s1 = new Student(1029, "Bianca", "Popescu", "TI131/1");
    s1.setNota(9.10f);
    studenti.put(1029, s1);

    Student s2 = new Student(1024, "Ioan", "Mihalcea", "ISM141/1");
    s2.setNota(9.80f);
    studenti.put(1024, s2);

    float notaM = gasesteNota("Bianca", "Popescu", studenti);
    float notaN = gasesteNota("Ioan", "Popa", studenti);

    System.out.println("Nota Bianca Popescu: " + notaM);
    System.out.println("Nota Ioan Popa: " + notaN);
}

    public static float gasesteNota (String prenume, String nume, HashMap < Integer, Student > studenti) {
        HashMap<String, Student> map = new HashMap<>();
        for (Student s : studenti.values()) {
            String key = s.getPrenume() + "-" + s.getNume();
            map.put(key, s);
        }
        Student rezultat = map.get(prenume + "-" + nume);
        if (rezultat != null) {
            return rezultat.getNota();
        }
        return 0.0f;
    }
        public static boolean existaStudent (List < Student > lista, Student cautat){
            for (Student s : lista) {
                if (s.getPrenume().equals(cautat.getPrenume()) &&
                        s.getNume().equals(cautat.getNume()) &&
                        s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) ;
                return true;
            }
            return false;
        }
//aa