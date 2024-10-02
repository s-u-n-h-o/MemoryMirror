package generics.boxInBox;

public class Box<T> {
    private T ob;

    public void setOb(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
