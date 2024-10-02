package test;

/*
* 1. 1 -45 까지 있는 볼을 로또기계에 넣는다
* 2. 로또기계에 있는 볼을 섞는다
* 3. 섞인 볼중에서 6개를 꺼낸다
* */
public interface LottoMachine {
    int MAX_BALL_COUNT = 45; //(public static ~) 이 생략되어있다.
    int RETURN_BALL_COUNT = 6;
    public void setBalls(Ball[] balls); //볼 배열 (abstract 생략가능)
    public void mix(); //자기가 가지고있는 볼을 섞는다.
    public Ball[] getBalls(); //6개의 볼을 반환한다.

}
