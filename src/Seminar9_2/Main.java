package Seminar9_2;

public class Main {
    public static void main(String[] args) {
        Numric<Integer> intOb = new Numric<>(5);
        System.out.println("Обратная величина intOb: " + intOb.recNum());
        System.out.println("Дробная часть intOb:" + intOb.fract());

        Numric<Double> dOb = new Numric<>(5.66);
        System.out.println("Обратная величина dOb: " + dOb.recNum());
        System.out.println("Дробная часть dOb:" + dOb.fract());
        System.out.printf("-------------------------------");

        intOb = new Numric<>(6);
        dOb = new Numric<>(-6.0);
        Numric<Long> lOb = new Numric<>(5L);
        System.out.println("Сравнение intOb и dOb: ");
        if (intOb.absEqual(dOb)){
            System.out.println("абсллютные значения совпадают");
        } else {
            System.out.println("абсллютные значения отличаются");
        }

        System.out.println("Сравнение intOb и lOb: ");
        if (intOb.absEqual(lOb)){
            System.out.println("абсллютные значения совпадают");
        } else {
            System.out.println("абсллютные значения отличаются");
        }

    }
}
