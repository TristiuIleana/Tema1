package lab3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText {
    private String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> citeste() {

        List<Student> lista = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName)
                    );

            // sarim peste header
            reader.readLine();

            String linie;

            while ((linie = reader.readLine()) != null) {

                String[] parti = linie.split(",");

                if (parti.length < 5) {
                    continue;
                }

                int matricol =
                        Integer.parseInt(parti[0].trim());

                String prenume =
                        parti[1].trim();

                String nume =
                        parti[2].trim();

                String formatie =
                        parti[3].trim();

                float nota =
                        Float.parseFloat(parti[4].trim());

                Student s =
                        new Student(
                                matricol,
                                prenume,
                                nume,
                                formatie,
                                nota
                        );

                lista.add(s);
            }

            reader.close();

            System.out.println(
                    "Citire TXT gata: "
                            + lista.size()
                            + " studenti"
            );

        } catch (Exception e) {

            System.out.println(
                    "Eroare TXT: "
                            + e.getMessage()
            );
        }

        return lista;
    }
}
