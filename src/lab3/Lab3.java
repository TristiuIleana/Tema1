package lab3;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.nio.file.Paths;

public class Lab3 {
    public static void main(String[] args ) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("in.txt"));
        List<String> rezultat  = new ArrayList<>();
        System.out.println("a)");
        for(String line : lines ) {
            String mod = line + "\n";
            System.out.println(mod);
            rezultat.add(mod);
        }
        System.out.println("b)");
        for(String line : lines){
            String[] propozitii = line.split("\\.");
            for(String p : propozitii){
                if(!p.trim().isEmpty()){
                    String mod = p.trim() + ".\n";
                    System.out.println(mod);
                    rezultat.add(mod);
                }
            }
        }

        Files.write(Paths.get("out.txt"), rezultat);
        System.out.println("Rezultatul este scris in out.txt");
    }
}
