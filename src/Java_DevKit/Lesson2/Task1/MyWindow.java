package Java_DevKit.Lesson2.Task1;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WIN_WIDTH = 800;
    private static final int WIN_HEIGTH = 600;
    private final Sprite[] sprites = new Sprite[10];

    MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIN_WIDTH, WIN_HEIGTH);
        setTitle("Кружки");

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this );
        add(canvas);
        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    };

    public static void main(String[] args) {
        new MyWindow();
    }
}
