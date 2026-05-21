package lab3;
import java.util.List;

public class Decorator implements IStudentiExport{
    private IStudentiExport exporter;
    public Decorator(IStudentiExport exporter) {
        this.exporter = exporter;
    }
    @Override
    public void doExport(List<Student> studenti) {

        long start = System.currentTimeMillis();

        exporter.doExport(studenti);

        long finish = System.currentTimeMillis();

        System.out.println(
                "Execution time: "
                        + (finish - start)
                        + " ms"
        );
    }
}
