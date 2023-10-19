package Java_DevKit.Lesson2.Task3.bricks;

import Java_DevKit.Lesson2.Task3.common.Background;
import Java_DevKit.Lesson2.Task3.common.MainCanvas;
import Java_DevKit.Lesson2.Task3.common.CanvasRepaintListener;
import Java_DevKit.Lesson2.Task3.common.Interactable;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WIN_WIDTH = 800;
    private static final int WIN_HEIGTH = 600;
    private final Interactable[] interactables = new Interactable[10];

    MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIN_WIDTH, WIN_HEIGTH);
        setTitle("Квадраты");

        interactables[0] = new Background();
        for (int i = 1; i < interactables.length; i++) {
            interactables[i] = new Bricks();
        }

        MainCanvas canvas = new MainCanvas(this );
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }
}
