package lab8;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    public static final String INPUT_FILE = "laborator8_input.xlsx";
    public static final String OUTPUT2_FILE = "laborator8_output2.xlsx";

    public static void read(String filePath) throws IOException {
        System.out.println("Citire fisier: " + filePath);
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook woorkbook = new XSSFWorkbook(fis)) {
            for (int s = 0; s < woorkbook.getNumberOfSheets(); s++) {
                Sheet sheet = woorkbook.getSheetAt(s);
                for (Row row : sheet) {
                    StringBuilder sb = new StringBuilder("Row " + row.getRowNum() + ": ");
                    for (Cell cell : row) {
                        sb.append("[").append(getCellValue(cell)).append("] ");
                    }
                    System.out.println(sb.toString().trim());
                }
            }
        }
    }


    public static void CopiazaValMediei(String inputPath, String outputPath) throws IOException{

        try (FileInputStream fis = new FileInputStream(inputPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            for (int s = 0; s < workbook.getNumberOfSheets(); s++) {
                Sheet sheet = workbook.getSheetAt(s);

                for (Row row : sheet) {
                    int last = row.getLastCellNum();
                    if (last < 3) {
                        row.createCell(last).setCellValue("N/A");
                        continue;
                    }

                    double sum = 0;
                    int count = 0;
                    for (int c = last - 3; c < last; c++) {
                        Cell cell = row.getCell(c);
                        if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                            sum += cell.getNumericCellValue();
                            count++;
                        }
                    }

                    Cell avgCell = row.createCell(last);
                    if (count > 0) avgCell.setCellValue(sum / count);
                    else           avgCell.setCellValue("N/A");
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
            }
        }
        System.out.println("Generat: " + outputPath + "\n");
    }
    public static void copieCuFormMedie(String inputPath, String outputPath) throws IOException {
        System.out.println("=== 8.5.3 – Generare: " + outputPath + " ===");

        try (FileInputStream fis = new FileInputStream(inputPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            for (int s = 0; s < workbook.getNumberOfSheets(); s++) {
                Sheet sheet = workbook.getSheetAt(s);

                for (Row row : sheet) {
                    int last      = row.getLastCellNum();
                    int excelRow  = row.getRowNum() + 1; // 1-indexed
                    String formula = "AVERAGE(D" + excelRow + ":F" + excelRow + ")";
                    row.createCell(last).setCellFormula(formula);
                }
            }

            workbook.setForceFormulaRecalculation(true);

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbook.write(fos);
            }
        }
        System.out.println("Generat: " + outputPath + "\n");
    }
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case NUMERIC:
                double v = cell.getNumericCellValue();
                return (v == Math.floor(v) && !Double.isInfinite(v))
                        ? String.valueOf((long) v)
                        : String.valueOf(v);
            case STRING:  return cell.getStringCellValue();
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return cell.getCellFormula();
            case BLANK:   return "";
            default:      return "?";
        }
    }

}
