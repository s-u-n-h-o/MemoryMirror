package polymorphism;

public class Buyer {//구매자
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product product) { //부모인 product를 매개변수로 받으면 해당 자식들을 전부 사용할수있다.
        money = money + product.price;
        bonusPoint = bonusPoint + product.bonusPoint;
    }

//이렇게 하면 tv,computer말고 기기가 50개 추가되면 이렇게 추가해주는것만큼 끔찍한일도 없을것
//    void buy(Tv tv) {
//        money = money + tv.price;
//        bonusPoint = bonusPoint + tv.bonusPoint;
//    }
//
//    void buy(Computer computer) {
//        money = money + computer.price;
//        bonusPoint = bonusPoint + computer.bonusPoint;
//    }
}
