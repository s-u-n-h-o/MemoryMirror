package generics.lowerBoundedWildcard;

import listTest.Set.Num;

public class main {
    public static void main(String[] args) {
        Box<Integer> iBox = new Box<>();
        iBox.setItem(1234);

        Box<Number> nBox = new Box<>();
        nBox.setItem(5678);

        Box<Object> oBox = new Box<>();
        oBox.setItem("인스턴스생성");

        UnBoxer.peekBox(iBox);
        UnBoxer.peekBox(nBox);
        UnBoxer.peekBox(oBox);
    }
}
