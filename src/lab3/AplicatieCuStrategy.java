package lab3;
import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {

    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",     "ISM141/2", 8.70f),
                new Student(1024, "Ioan",     "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan",   "TI131/1",  8.90f),
                new Student(1029, "Bianca",   "Popescu",  "TI131/1",  10f),
                new Student(1029, "Maria",    "Pana",     "TI131/2",  4.10f),
                new Student(1029, "Gabriela", "Mohanu",   "TI131/2",  7.33f),
                new Student(1029, "Marius",   "Nasta",    "TI131/2",  3.20f),
                new Student(1029, "Marius",   "Nasta",    "TI131/1",  5.12f),
                new Student(1029, "Andrei",   "Dobrescu", "TI131/2",  2.22f)
        );

        Exporter exporter = new Exporter();

        // a) afisare in consola
        System.out.println("a) Consola");
        IStudentiExport strategyConsola = new StudentiInConsola();
        exporter.startExport(strategyConsola, studenti);

        // b) export in fisier txt
        System.out.println("b) Fisier TXT");
        StudentiInFisierText strategyTxt = new StudentiInFisierText("studentiStrategyText.txt");
        exporter.startExport(strategyTxt, studenti);

        // c) export in fisier xls
        System.out.println("c) Fisier XLS");
        StudentiInFisierXlsx strategyXls = new StudentiInFisierXlsx("studentiStrategyExcel.xlsx");
        exporter.startExport(strategyXls, studenti);

        // d) citire din fisier txt
        System.out.println("d) Citire din TXT ");
        StudentiDinFisierText cititText = new StudentiDinFisierText("studentiStrategyText.txt");
        List<Student> dinTxt = cititText.citeste();
        for (Student s : dinTxt) {
            System.out.println(s);
        }

        // e) citire din fisier xls
        System.out.println("e) Citire din XLS ");
        StudentiDinFisierXlsx cititXls = new StudentiDinFisierXlsx("studentiStrategyExcel.xlsx");
        List<Student> dinXls = cititXls.citeste();
        for (Student s : dinXls) {
            System.out.println(s);
        }
    }
}
