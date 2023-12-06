package Java_DevKit.HW5;

public class Main {
    public static void main(String[] args) {

        Philosoph philosoph_1 = new Philosoph(500, 5000, 3,"Философ-1");
        Philosoph philosoph_2 = new Philosoph(500, 2000, 3,"Философ-2");
        Philosoph philosoph_3 = new Philosoph(500, 1000, 3,"Философ-3");
        Philosoph philosoph_4 = new Philosoph(500, 1500, 3,"Философ-4");
        Philosoph philosoph_5 = new Philosoph(500, 3000, 3,"Философ-5");
        philosoph_1.start();
        philosoph_2.start();
        philosoph_3.start();
        philosoph_4.start();
        philosoph_5.start();
    }
}