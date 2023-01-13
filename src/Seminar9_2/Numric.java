package Seminar9_2;

public class Numric<T extends Number> {

    T num;
    Numric(T n){
        num = n;
    }

    double recNum(){
        return 1 / num.doubleValue();
    }

    double fract(){
        return num.doubleValue() - num.intValue();
    }

    boolean absEqual(Numric<?> ob){
        if (Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue())){
            return true;
        }
        return false;
    }
}
