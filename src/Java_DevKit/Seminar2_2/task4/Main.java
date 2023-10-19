package Java_DevKit.Seminar2_2.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        List<Developer> developers = new ArrayList<>();

        // заполним список разработчиков случайно Back и Front разработчиками
        int tempInt = rand.nextInt(5, 10);
        for (int i = 0; i < tempInt; i++) {
            int type = rand.nextInt(1,4);
            switch (type) {
                case 1 -> developers.add(new FrontEndDeveloper());
                case 2 -> developers.add(new BackEndDeveloper());
                case 3 -> developers.add(new FullStackProgrammer());
            }
        }

        // проверка разработчиков на умение кодить GUI
        for (Developer developer : developers) {
            checkSpec(developer);
        }

        var backPr = new BackEndProgramming() {
            @Override
            public void writeBackEndCode() {
            }
        };
        var frontPr = new FrontEndProgramming() {
            @Override
            public void writeFrontEndCode() {
            }
        };

        System.out.println("\n--------------------------\n");
        FullStackProgrammer programmer = new FullStackProgrammer();
        programmer.writeBackEndCode();
        programmer.writeFrontEndCode();
        programmer.relax();
        programmer.sleeping();
        System.out.println("\n--------------------------\n");
        System.out.println("Class name Object backPr: " + backPr.getClass());
        System.out.println("Class name Object frontPr: " + frontPr.getClass().getName());
    }

    static void checkSpec(Developer developer) {
        if (developer instanceof FrontEndDeveloper) {
            ((FrontEndDeveloper) developer).writeFrontEndCode();
        } else if (developer instanceof FullStackProgrammer) {
            ((FullStackProgrammer) developer).writeFrontEndCode();
        } else {
            System.out.println("Class name: " + developer.toString() + " -> Create GUI not supported by this Developer");
        }
    }
}
