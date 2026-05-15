package lab3;
import java.util.List;
public class Exporter {
    public void startExport(IStudentiExport strategy, List<Student> studenti) {
        strategy.doExport(studenti);
    }
}
