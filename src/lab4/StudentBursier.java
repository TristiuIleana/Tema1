package lab4;

import java.util.Objects;

public class StudentBursier extends Student{
    private double cuantumBursa;
    public StudentBursier(int numarMatricol, String prenume,String nume, String ForamtieDeStudiu,float nota, double bursa)
    {
        super(numarMatricol, prenume,nume, ForamtieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = bursa;

    }
    public double getCuantumBursa(){
        return cuantumBursa;
    }
    @Override
    public String toString(){
        return  super.toString() + " bursa=" + cuantumBursa;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof StudentBursier))
            return false;
        if(!super.equals(o))
            return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(this.cuantumBursa, cuantumBursa) == 0;
    }
    public int hashCode(){
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}
