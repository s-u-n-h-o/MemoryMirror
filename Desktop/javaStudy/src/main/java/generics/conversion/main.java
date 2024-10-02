package generics.conversion;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<Apple>(); //타입변수를 apple로 지정
        FruitBox<Orange> orangeBox = new FruitBox<Orange>(); //타입변수를 orange로 지정

        appleBox.setItem(new Apple()); //사과담기
        orangeBox.setItem(new Orange()); //오렌지 담기

        Apple apple = appleBox.getItem(); //T를 apple로 하여 인스턴스 생성
        Orange orange = orangeBox.getItem();

        System.out.println(apple); // "난 사과" -> get 메소드의 반환형이 apple로 결정되기때문에 형변환을 할 필요가 없다
        System.out.println(orange);

    }
}
