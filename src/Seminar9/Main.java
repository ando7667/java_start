package Seminar9;

public class Main {
    public static void main(String[] args) {

        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);
        iOb.showType();
        int v = iOb.getOb();
        System.out.println("Значение " + v);

        Gen<String> strOb = new Gen<>("Test message");
        strOb.showType();
        System.out.println("Значение " + strOb.getOb());

    }
}

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println("тип это - " + ob.getClass().getName());
    }
}