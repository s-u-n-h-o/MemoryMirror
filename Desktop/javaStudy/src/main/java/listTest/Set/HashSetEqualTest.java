package listTest.Set;

import java.util.HashSet;

public class HashSetEqualTest {

    public static void main(String[] args) {
        HashSet<Num> set = new HashSet<>();
        set.add(new Num(1122));
        set.add(new Num(3344));
        set.add(new Num(1122));

        System.out.println("인스턴스 수 : " + set.size());

        for(Num n : set) {
            System.out.println(n.toString());
        }
    }
}
