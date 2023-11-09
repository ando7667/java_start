package Java_DevKit.HW5;

import java.util.concurrent.atomic.AtomicBoolean;

public class Philosoph extends Thread {
    static volatile AtomicBoolean someone_is_eating = new AtomicBoolean(false);
    private boolean state_eat;      //  состояние true - ест, false - размышляет
    private final int time_eat;
    private final int time_think;
    private int count_eat;

    /**
     *
     * @param time_eat   - время еды
     * @param time_think - время размышления
     * @param count_eat  - количество обедов
     * @param name      - Имя философа
     */
    public Philosoph(int time_eat, int time_think, int count_eat, String name) {
        super(name);
        this.state_eat = false;
        this.time_eat = time_eat;
        this.time_think = time_think;
        this.count_eat = count_eat;
    }
    @Override
    public void run() {
        try {
            System.out.println("Поток: " + Thread.currentThread().getName());
            System.out.printf("Философ %s начал размышлять\n", getName());
            while (this.count_eat > 0) {
                if (!someone_is_eating.get()) {
                    someone_is_eating.set(true);
                    this.state_eat = true;
                    System.out.printf("Философ %s кушает\n", getName());
                    Thread.sleep(time_eat);
                    this.count_eat--;
                    this.state_eat = false;
                    someone_is_eating.set(false);
                    System.out.printf("Философ %s продолжает размышлять\n", getName());
                    Thread.sleep(this.time_think);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}