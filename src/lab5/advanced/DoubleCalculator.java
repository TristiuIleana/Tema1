package lab5.advanced;

public class DoubleCalculator extends ACalculator {
    public DoubleCalculator(double value){
        this.state = value;
    }
    public DoubleCalculator  add(double value){
        state = (Double) state + value;
        return this;
    }
    public DoubleCalculator subtract(double value){
        state = (Double) state - value;
        return this;
    }
    public DoubleCalculator multiply(double value){
        state = (Double) state * value;
        return this;
    }
    @Override
    protected void init() {

        state = 0.0;
    }
}
