package generics.boxInBox;

public class main {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.setOb("박스");

        Box<Box<String>> box2 = new Box<>();
        box2.setOb(box);

        Box<Box<Box<String>>> box3 = new Box<>();
        box3.setOb(box2);

        System.out.println(box3.getOb());
        System.out.println(box3.getOb().getOb());
        System.out.println(box3.getOb().getOb().getOb());

    }
}
