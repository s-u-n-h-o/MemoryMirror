package test;

public class LottoMachineMain {

    public static void main(String[] args) {
        //변수가 45개 필요
        Ball[] ball = new Ball[LottoMachine.MAX_BALL_COUNT];
        for(int i = 0 ; i < LottoMachine.MAX_BALL_COUNT ; i++) {
            ball[i] = new Ball(i +1);
        }

        //로또머신 인스턴스가 생성된다.
        LottoMachine lottoMachine = new LottoMachineImpl();
        lottoMachine.setBalls(ball);
        lottoMachine.mix();
        Ball[] result = lottoMachine.getBalls();

        for(int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i].getNumber());
        }
    }
}
