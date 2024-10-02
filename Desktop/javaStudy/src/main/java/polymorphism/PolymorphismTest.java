package polymorphism;

public class PolymorphismTest {

    public static void main(String[] args) {
        Buyer buyer = new Buyer();

        buyer.buy(new Computer(200, 100));//Computer(자식)을 넣었지만 Product(부모)로 다형성 매개변수로 받았다.
        buyer.buy(new Tv(100, 50)); //Tv(자식)을 넣었지만 Product(부모)로 업캐스팅하여 다형성매개변수로 받았다

        //computer와 tv의 money와 bonusPoint의 값이 계산되어 결과값이 나온다
        System.out.println(buyer.money); //1300
        System.out.println(buyer.bonusPoint); //150
    }
}

