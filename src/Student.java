import java.util.Objects;

public class Student {
        private String numarMatricol;
        private String prenume;
        private String nume;
        private String formatieDeStudiu;
        public Student(String numarMatricol,String prenume,String nume,String formatieDeStudiu){
            this.numarMatricol = numarMatricol;
            this.prenume = prenume;
            this.nume = nume;
            this.formatieDeStudiu = formatieDeStudiu;
        }
        @Override
        public String toString(){
            return numarMatricol + " " + prenume + " " + nume + " " + formatieDeStudiu;
        }
        public String getPrenume(){
            return prenume;
        }
        public String getNume(){
            return nume;
        }
        public String getFormatieDeStudiu(){
            return formatieDeStudiu;
        }


        public boolean equals(Object o){
            if (this == o)
                return true;
            if(!(o instanceof Student))
                return false;
            Student s = (Student) o;
            return prenume.equals(s.prenume) &&
                    nume.equals(s.nume) &&
                    formatieDeStudiu.equals(s.formatieDeStudiu);
        }
        public int hashCode(){
            return prenume.hashCode() + nume.hashCode() + formatieDeStudiu.hashCode();
        }
}
