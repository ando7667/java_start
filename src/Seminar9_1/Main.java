package Seminar9_1;

public class Main {
    public static void main(String[] args) {
        TwoGen<Integer, String> twOb = new TwoGen<>(88, "Обобщение");
        twOb.showTypes();
        System.out.println("Значение Т: " + twOb.getOb1() + "\nЗначение V: " + twOb.getOb2());
    }
}
