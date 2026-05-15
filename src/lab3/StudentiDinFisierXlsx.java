package lab3;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx {

    private String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    public List<Student> citeste() {

        List<Student> lista = new ArrayList<>();

        try {

            FileInputStream fis =
                    new FileInputStream(fileName);

            Workbook workbook =
                    new XSSFWorkbook(fis);

            Sheet sheet =
                    workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                int matricol =
                        (int) row.getCell(0)
                                .getNumericCellValue();

                String prenume =
                        row.getCell(1)
                                .getStringCellValue();

                String nume =
                        row.getCell(2)
                                .getStringCellValue();

                String formatie =
                        row.getCell(3)
                                .getStringCellValue();

                float nota =
                        (float) row.getCell(4)
                                .getNumericCellValue();

                lista.add(
                        new Student(
                                matricol,
                                prenume,
                                nume,
                                formatie,
                                nota
                        )
                );
            }

            workbook.close();
            fis.close();

            System.out.println(
                    "Citire XLSX gata: "
                            + lista.size()
                            + " studenti"
            );

        } catch (Exception e) {

            System.out.println(
                    "Eroare XLSX: "
                            + e.getMessage()
            );
        }

        return lista;
    }
}