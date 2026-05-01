
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import lab4.Student;
import static lab4.Student.existaStudent;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    class MainStudenti {

        private static final String XLS_FILE = "laborator8_students.xls";
        private static final String[] HEADERS = {"NumarMatricol", "Prenume", "Nume", "FormatieDeStudiu", "Nota"};

        // 8.5.4 a) Export
        public static void exportStudenti(List<Student> studenti, String filePath) throws IOException {
            try (Workbook wb = new HSSFWorkbook()) {
                Sheet sheet = wb.createSheet("Studenti");

                // Header
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

                // Date
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
            System.out.println("Export OK: " + studenti.size() + " studenti -> " + filePath);
        }

        // 8.5.4 b) Import
        public static List<Student> importStudenti(String filePath) throws IOException {
            List<Student> lista = new ArrayList<>();

            try (FileInputStream fis = new FileInputStream(filePath);
                 Workbook wb = new HSSFWorkbook(fis)) {

                Sheet sheet = wb.getSheetAt(0);
                boolean skipHeader = true;

                for (Row row : sheet) {
                    if (skipHeader) {
                        skipHeader = false;
                        continue;
                    }

                    int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                    String prenume = row.getCell(1).getStringCellValue();
                    String nume = row.getCell(2).getStringCellValue();
                    String formatieDeStudiu = row.getCell(3).getStringCellValue();
                    float nota = (float) row.getCell(4).getNumericCellValue();

                  //  lista.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu, nota));
                }
            }

            System.out.println("Import OK: " + lista.size() + " studenti din " + filePath);
            lista.forEach(System.out::println);
            return lista;
        }
    }
}
