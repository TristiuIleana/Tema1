package lab3;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {

    private String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {

        try {

            FileWriter writer = new FileWriter(fileName);

            writer.write("numarMatricol,prenume,nume,formatie,nota\n");

            for (Student s : studenti) {

                writer.write(
                        s.getNumarMatricol() + ","
                                + s.getPrenume() + ","
                                + s.getNume() + ","
                                + s.getFormatieDeStudiu() + ","
                                + s.getNota() + "\n"
                );
            }

            writer.close();

            System.out.println("Export TXT realizat: " + fileName);

        } catch (IOException e) {

            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
