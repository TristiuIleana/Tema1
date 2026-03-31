package lab5;

public class AdvancedCalculator extends IntCalculator {
    public AdvancedCalculator(int initial){
        super(initial);
    }
    public AdvancedCalculator divide(int value){
        if(value !=0){
            int result = result() / value;
            clear().add(result);
        }
        return this;
    }
    public AdvancedCalculator root(int n){
        int result = (int) Math.pow(result(), 1.0/n);
        clear().add(result);
        return this;
    }
    public AdvancedCalculator power(int exp){
        int result = (int) Math.pow(result(), exp);
        clear().add(result);
        return this;
    }
}
