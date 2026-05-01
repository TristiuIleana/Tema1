package lab8;
import java.io.IOException;
import java.util.ArrayList;
import lab3.Student;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.*;
import org.apache.poi.ss.usermodel.*;
public class Mainlab8 {
    private static final String XLS_FILE = "laborator8_students.xls";
    private static final String[] HEADERS = {"NumarMatricol", "Prenume", "Nume", "FormatieDeStudiu", "Nota"};

    public static void exportStudenti(List<Student> studenti, String filePath) throws IOException {
        try (Workbook wb = new HSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Studenti");
            CellStyle headerStyle = wb.createCellStyle();
            Font font = wb.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(HEADERS[i]);
                cell.setCellStyle(headerStyle);
            }
            int rowIdx = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(s.getNumarMatricol());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                row.createCell(4).setCellValue(s.getNota());
            }
            for (int i = 0; i < HEADERS.length; i++) sheet.autoSizeColumn(i);
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                wb.write(fos);
            }
        }
        System.out.println("Export OK: " + studenti.size() + " studenti");
    }

    public static List<Student> importStudenti(String filePath) throws IOException {
        List<Student> lista = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook wb = new HSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheetAt(0);
            boolean skipHeader = true;
            for (Row row : sheet) {
                if (skipHeader) { skipHeader = false; continue; }
                int    numarMatricol    = (int) row.getCell(0).getNumericCellValue();
                String prenume          = row.getCell(1).getStringCellValue();
                String nume             = row.getCell(2).getStringCellValue();
                String formatieDeStudiu = row.getCell(3).getStringCellValue();
                float  nota             = (float) row.getCell(4).getNumericCellValue();
                lista.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu, nota));
            }
        }
        System.out.println("Import OK: " + lista.size() + " studenti");
        lista.forEach(System.out::println);
        return lista;
    }
    public static void main(String[] args) {
        try {
            WriteExcel.read(WriteExcel.INPUT_FILE);
            WriteExcel.CopiazaValMediei(WriteExcel.INPUT_FILE, WriteExcel.OUTPUT2_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student(1001, "Ion",      "Popescu",    "3121A", 9.5f));
        studenti.add(new Student(1002, "Maria",    "Ionescu",    "3122B", 8.7f));
        studenti.add(new Student(1003, "Andrei",   "Georgescu",  "3121A", 7.3f));
        studenti.add(new Student(1004, "Elena",    "Dumitrescu", "3123C", 9.1f));
        studenti.add(new Student(1005, "Mihai",    "Stanescu",   "3122B", 6.8f));

        try {
            exportStudenti(studenti, XLS_FILE);           // 8.5.4 a)
            List<Student> importati = importStudenti(XLS_FILE); // 8.5.4 b)
            System.out.println("Total: " + importati.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
