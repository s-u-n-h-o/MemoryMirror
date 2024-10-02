package lambda.example1;

public class LambdaInfo {
    public static void main(String[] args) {

    }
}

class Outer {
    int val = 10;
     class Inner {
         int val = 20;

         void method (int i) {
             int val = 30;
             i = 10;


         }
     }
}
