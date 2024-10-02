package generics.lowerBoundedWildcard;

public class Box <T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
