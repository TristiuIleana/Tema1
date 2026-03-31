package lab5.advanced;

public abstract class ACalculator {
    protected Object state;

    public Object result(){
        return result();
    }

    public ACalculator clear(){
        init();
        return this;
    }
    protected abstract void init();
}
