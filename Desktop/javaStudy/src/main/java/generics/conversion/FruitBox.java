package generics.conversion;

public class FruitBox<T> {
    // 형변환이 불필요해진다.
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
