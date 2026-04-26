package lab7;
import lab7.forms.Triangle;
import lab7.forms.Circle;
import lab7.forms.Square;
import lab7.forms.Form;
import lab7.util.StringRandomizer;
import lab7.util.PasswordMaker;

import java.util.List;
import java.util.ArrayList;
import lab3.Student;
public class Main {
    public static void main(String[] args) {

        // 7.6.1. Contor instante
        Triangle tri = new Triangle(1.1F, 2.0F, "red");
        Circle c = new Circle(1.5F, "yellow");
        Square sq = new Square(1.2F, "blue");
        System.out.println("Area = " + tri.getArea() + " details: " + tri);
        System.out.println("Area = " + c.getArea() + " details: " + c);
        System.out.println("Area = " + sq.getArea() + " details: " + sq);
        System.out.println("Total instance count is " + Form.getInstanceCount());   // sau tri.getInstanceCount() sau sq.getInstanceCount()

        //7.6.2 Password maker singleton
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("\n7.6.2 a+b) Generated passwords: ");
        System.out.println("1:" + PasswordMaker.getInstance().getPassword());
        System.out.println("2:" + PasswordMaker.getInstance().getPassword());
        System.out.println("3:" + PasswordMaker.getInstance().getPassword());
        System.out.println("4:" + pm2.getPassword());
        System.out.println("5:" + pm2.getPassword());
        System.out.println("\n7.6.2 c) Number of time getInstance() has been called: " + PasswordMaker.getCallingCount());

        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student(1, "Ioana", "Popa", "TI21/1", 9));
        studenti.add(new Student(2, "Elena", "Ionescu", "TI21/2", 8));
        studenti.add(new Student(3, "Maria", "Popescu", "TI21/1", 7));
        studenti.add(new Student(4, "Irina", "Pop", "TI21/2", 6));
        studenti = imparteInDouaFormatii(
                studenti,
                "TI21/1",
                "TI21/2"
        );
        for(Student s  : studenti){
            System.out.println(s);
        }
    }

        static Student schimbaFormatia(Student st, String nouaFormatie){
            return new Student(
                    st.getNumarMatricol(),
                    st.getPrenume(),
                    st.getNume(),
                    nouaFormatie,
                    st.getNota()
            );
        }
        static List<Student> imparteInDouaFormatii(List<Student> studenti, String f1, String f2){
            List<Student> rezultat = new ArrayList<>();
            int i = 0;
            int jumatate = (studenti.size() + 1) / 2;
            for(Student s : studenti){
                if(i < jumatate){
                    rezultat.add(schimbaFormatia(s,f1));
                }else{
                    rezultat.add(schimbaFormatia(s,f2));
                }
                i++;
            }
            return rezultat;
        }

}
a
