package generics.boundedWildcard;

class Box2<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }
    public T getItem() {
        return item;
    }
}
class Toy2 {
    @Override
    public String toString() {
        return "Toy클래스";
    }
}

class BoxHandler2 {
    public static void outBox(Box<? extends Toy> box) {
        Toy t = box.getItem();
        //box.setItem(new Toy()); //에러 남
        System.out.println(t); //상자에서 꺼낸다.
    }
    public static void inBox(Box<Toy> box , Toy n) {
        box.setItem(n); //상자에 넣는다.
    }
}

public class BoundedWildcard2 {
    public static void main(String[] args) {
        Box<Toy> box = new Box<>();
        BoxHandler.inBox(box, new Toy());
        BoxHandler.outBox(box);
    }
}
