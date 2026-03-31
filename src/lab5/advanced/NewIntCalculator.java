package lab5.advanced;

public class NewIntCalculator extends ACalculator{
    public NewIntCalculator(int value){
        this.state = value;
    }
    public NewIntCalculator add(int value){
        state = (Integer) state + value;
        return this;
    }
    public NewIntCalculator subtract(int value){
        state = (Integer) state - value;
        return this;
    }
    public NewIntCalculator multiply(int value){
        state = (Integer) state * value;
        return this;
    }
    @Override
    protected void init() {
        state = 0;
    }
}
