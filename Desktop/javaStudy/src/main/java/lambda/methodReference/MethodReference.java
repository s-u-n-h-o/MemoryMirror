package lambda.methodReference;

import java.util.function.Function;

public class MethodReference {

    Integer wrapper(String s) {
        return Integer.parseInt(s);
    }

    //위의 메서드를 람다로 바꿔 더 간단하게 진행한다
    Function<String, Integer> f = (String s) -> Integer.parseInt(s);

    //하나의 메서드만 호출하는 경우라서 메서드 참조로 더 간단히 사용이 가능하다
    Function<String, Integer> f1 = Integer::parseInt;

}
