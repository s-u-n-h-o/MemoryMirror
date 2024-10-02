package listTest.Set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {

        // HashSet 데이터 사용
        Set<String> s = new HashSet<>();
        s.add("red");
        s.add("yellow");
        s.add("green");
        s.add("red"); //중복 데이터가 들어갈 경우

        System.out.println("인스턴스의 수 : " + s.size());

        for(String slist : s) {
            System.out.println(slist);
        }
    }
}
