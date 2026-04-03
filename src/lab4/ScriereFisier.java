package lab4;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
public class ScriereFisier {
    public static void writeToFile(String filename,Collection<?extends Student> studenti){
        try(FileWriter writer = new FileWriter(filename)){
            for(Student s : studenti){
                writer.write(s.toString());
                writer.write("\n ");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
