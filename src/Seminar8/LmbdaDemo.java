package Seminar8;

public class LmbdaDemo {
    public static void main(String[] args) {


        MyNums myNum;
        myNum = () -> 98.6;  // простое лямбда выражение

        System.out.println("постоянное значение " + myNum.getNum());

        MyParamNums paramNum = (n) -> 1.0/n;
        System.out.println("обратная величина 4 = " + paramNum.getNums(4.0));
        System.out.println("обратная величина 8 = " + paramNum.getNums(8.0));

    }
}
