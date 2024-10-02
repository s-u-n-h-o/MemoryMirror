package generics.lowerBoundedWildcard;

public class UnBoxer {
    public static void peekBox(Box<? super Integer> box) { //상한제한
        System.out.println(box);
    }
}
