package lab3;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Lab3 {
    public static void main(String[] args ) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("in.txt"));
        List<String> rezultat  = new ArrayList<>();
        for(String line : lines ) {
            String[] words = line.split("\\s+");

            for(String w : words){
                lines.add(w);
            }
        }
        for(String s : lines){
            System.out.println(s);
        }
        System.out.println("a) newlinw la fiecare linie: ");
        for(String line : lines){
            String[] parts = line.split("\\n");
            for(String p : parts){
                String mod = p + "\n";
                System.out.println(mod);
                rezultat.add(mod);
            }
        }
    }
}
