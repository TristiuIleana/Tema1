package advanced;

public abstract class ACalculator<T> {
     protected T state;

    abstract <S extends ACalculator<T>> S init();

    public T result() {
        return state;
    }

    public void clear() {
        state = null;
    }

}
