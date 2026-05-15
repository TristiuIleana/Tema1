package lab3;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class StudentiInFisierXlsx implements IStudentiExport {

    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {

        try {

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Studenti");

            Row header = sheet.createRow(0);

            header.createCell(0).setCellValue("Numar Matricol");
            header.createCell(1).setCellValue("Prenume");
            header.createCell(2).setCellValue("Nume");
            header.createCell(3).setCellValue("Formatie");
            header.createCell(4).setCellValue("Nota");

            int rand = 1;

            for (Student s : studenti) {

                Row row = sheet.createRow(rand);

                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());

                rand++;
            }

            FileOutputStream fos =
                    new FileOutputStream(fileName);

            workbook.write(fos);

            fos.close();
            workbook.close();

            System.out.println("Export XLSX gata: " + fileName);

        } catch (IOException e) {

            System.out.println("Eroare: " + e.getMessage());
        }
    }
}
