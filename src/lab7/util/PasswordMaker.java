package lab7.util;

public class PasswordMaker {
    private static final int MAGIC_NUMBER = 3;
    private static final String MAGIC_STRING;

    private String name;

    static {
        StringRandomizer srand = new StringRandomizer();
        MAGIC_STRING = srand.randomString(20);
    }

    private PasswordMaker(String name) {
        this.name = name;
    }
    private static PasswordMaker instance = null;
    private static int callingCount = 0;
    public static PasswordMaker getInstance(){
        callingCount++;
        if(instance == null){
            instance = new PasswordMaker("default");
        }
        return instance;
    }
    public static int getCallingCount(){
        return callingCount;
    }
    public String getPassword() {
        java.util.Random r = new java.util.Random();
        String ln = ""+name.length();
        ln += r.nextInt(101);
        StringRandomizer srand = new StringRandomizer();
        return srand.randomString(MAGIC_NUMBER) + srand.randomString(10, MAGIC_STRING) + ln;
    }
}

a