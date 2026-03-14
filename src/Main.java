public static void main(String[]  args) {
    Student student1 = new Student("615", "Ileana", "Tristiu", "21/1");
    System.out.println(student1);

    //Labortaor2 exercitiul1
    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    Random random = new Random();
    for (int i = 0; i < 8; i++) {
        x.add(random.nextInt(10));
    }
    for (int i = 0; i < 6; i++) {
        y.add(random.nextInt(10));
    }
    Collections.sort(x);
    Collections.sort(y);
    System.out.println("x = " + x);
    System.out.println("y = " + y);

    List<Integer> xPlusY = new ArrayList(); //a
    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("xPlusY = " + xPlusY);

    Set<Integer> zSet = new TreeSet(); //b
    for (Integer val : x) {
        if (y.contains(val)) {
            zSet.add(val);
        }
    }
    System.out.println("zSet = " + zSet);
    List<Integer> xMinusY = new ArrayList();//c
    for (Integer val : x) {
        if (!y.contains(val)) {
            xMinusY.add(val);
        }
    }
    System.out.println("xMinusY = " + xMinusY);

    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList();//d
    for (Integer val : xPlusY) {
        if (val <= p) {
            xPlusYLimitedByP.add(val);
        }
    }
    System.out.println("xPlusYLimitedByP = " + xPlusYLimitedByP);

    //exercitiul2
    List<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(new Student("120", "Alis", "Popa", "TI21/2"));
    listaStudenti.add(new Student("112", "Maria", "Popa", "TI21/1"));
    System.out.println("Lista: ");
    for (Student s : listaStudenti) {
        System.out.println(s.toString());
    }

    Student s1 = new Student("120", "Alis", "Popa", "TI21/2");
    boolean gasit = existaStudent(listaStudenti, s1);
    System.out.println("Exista Alis Popa in lista " + gasit);

    Student s2 = new Student("112", "Maria", "Popa", "TI21/1");
    boolean gasit2 = existaStudent(listaStudenti, s2);
    System.out.println("Exista Maria Popa in lista " + gasit2);

    Set<Student> setStudenti = new HashSet<>(listaStudenti);
    System.out.println("Exista Alis Popa in lista " + setStudenti.contains(s1));
    System.out.println("Exista Maria Popa in lista " + setStudenti.contains(s2));
}
    public static boolean existaStudent (List < Student > lista, Student cautat){
        for (Student s : lista) {
            if (s.getPrenume().equals(cautat.getPrenume()) &&
                    s.getNume().equals(cautat.getNume()) &&
                    s.getFormatieDeStudiu().equals(cautat.getFormatieDeStudiu())) ;
            return true;
        }
        return false;
    }
