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
        public String toString(){
            return numarMatricol + " " + prenume + " " + nume + " " + formatieDeStudiu;
        }
}
