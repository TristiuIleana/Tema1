public static void main(String[]  args) {
        Student student1 = new Student("615", "Ileana","Tristiu","21/1");
        System.out.println(student1);

        //Labortaor2 exercitiul1
    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    Random random = new Random();
    for(int i = 0; i<8;i++){
        x.add(random.nextInt(10));
    }
    for(int i=0;i<6;i++){
        y.add(random.nextInt(10));
    }
    Collections.sort(x);
    Collections.sort(y);
    List<Integer> xPlusY = new ArrayList(); //a
    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);

    Set<Integer> zSet = new TreeSet(); //b
    for(Integer val:x){
        if(y.contains(val)){
            zSet.add(val);
        }
    }
    List<Integer> xMinusY = new ArrayList();//c
    xMinusY.removeAll(y);

    int p = 4;
    List<Integer> xPlusYLimitedByP = new ArrayList();//d
    for(Integer val: xPlusY) {
        if(val <= p){
            xPlusYLimitedByP.add(val);
        }
    }

    //exercitiul2
    List<Student> listaStudenti = new ArrayList<>();
    listaStudenti.add(new Student("120","Alis","Popa","TI21/2"));
    listaStudenti.add(new Student("112","Maria","Popa","TI21/1"));
    System.out.println("Lista: ");
    for(Student s : listaStudenti){
        System.out.println(s.toString());
    }

}
