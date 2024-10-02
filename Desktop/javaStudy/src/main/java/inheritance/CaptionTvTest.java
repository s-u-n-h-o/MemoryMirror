package inheritance;

class Tv {
    boolean power; //전원상태
    int channel;  //채널

    void power() { power =! power;}
    void channelUp() {++channel;}
    void channerlDown() {--channel;}
}

class CaptionTv extends Tv {
    boolean caption;
    void displayCpation(String text) {
        if(caption) {
            System.out.println("text");
        }
    }
}

class CaptionTvTest {
    public static void main(String args[]) {
        CaptionTv ctv = new CaptionTv();
        ctv.channel = 10;
        ctv.channelUp();
        System.out.println(ctv.channel);
    }
}
