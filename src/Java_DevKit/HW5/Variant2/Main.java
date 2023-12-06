package Java_DevKit.HW5.Variant2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static AtomicInteger philosopher_1 = new AtomicInteger(); // 1 - кушает, 0 - размышляет
    static AtomicInteger philosopher_2 = new AtomicInteger();
    static AtomicInteger philosopher_3 = new AtomicInteger();
    static AtomicInteger philosopher_4 = new AtomicInteger();
    static AtomicInteger philosopher_5 = new AtomicInteger();
    static AtomicInteger foodTable = new AtomicInteger();  // 1 - стол занят, 0 - стол свободен
    static Random rand = new Random();
    public static void main(String[] args) {
        Thread philA = new Thread(() -> {
            int count = 0;
            try {
                System.out.println("Философ 1 начал размышлять");
                while (count != 3) {
                    if (foodTable.get() == 0) {
                        foodTable.set(1);
                        philosopher_1.set(1);
                        System.out.println("Философ 1 кушает");
                        Thread.sleep(500);
                        count++;
                        philosopher_1.set(0);
                        foodTable.set(0);
                        System.out.println("Философ 1 продолжает размышлять");
                        Thread.sleep(rand.nextInt(5000));
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread philB = new Thread(() -> {
            int count = 0;
            try {
                System.out.println("Философ 2 начал размышлять");
                while (count != 3) {
                    if (foodTable.get() == 0) {
                        foodTable.set(1);
                        philosopher_2.set(1);
                        System.out.println("Философ 2 кушает");
                        Thread.sleep(500);
                        count++;
                        philosopher_2.set(0);
                        foodTable.set(0);
                        System.out.println("Философ 2 продолжает размышлять");
                        Thread.sleep(rand.nextInt(5000));
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread philC = new Thread(() -> {
            int count = 0;
            try {
                System.out.println("Философ 3 начал размышлять");
                while (count != 3) {
                    if (foodTable.get() == 0) {
                        foodTable.set(1);
                        philosopher_3.set(1);
                        System.out.println("Философ 3 кушает");
                        Thread.sleep(500);
                        count++;
                        philosopher_3.set(0);
                        foodTable.set(0);
                        System.out.println("Философ 3 продолжает размышлять");
                        Thread.sleep(rand.nextInt(5000));
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread philD = new Thread(() -> {
            int count = 0;
            try {
                System.out.println("Философ 4 начал размышлять");
                while (count != 3) {
                    if (foodTable.get() == 0) {
                        foodTable.set(1);
                        philosopher_4.set(1);
                        System.out.println("Философ 4 кушает");
                        Thread.sleep(500);
                        count++;
                        philosopher_4.set(0);
                        foodTable.set(0);
                        System.out.println("Философ 4 продолжает размышлять");
                        Thread.sleep(rand.nextInt(5000));
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread philE = new Thread(() -> {
            int count = 0;
            try {
                System.out.println("Философ 5 начал размышлять");
                while (count != 3) {
                    if (foodTable.get() == 0) {
                        foodTable.set(1);
                        philosopher_5.set(1);
                        System.out.println("Философ 5 кушает");
                        Thread.sleep(500);
                        count++;
                        philosopher_5.set(0);
                        foodTable.set(0);
                        System.out.println("Философ 5 продолжает размышлять");
                        Thread.sleep(rand.nextInt(5000));
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        philA.start();
        philB.start();
        philC.start();
        philD.start();
        philE.start();
    }
}