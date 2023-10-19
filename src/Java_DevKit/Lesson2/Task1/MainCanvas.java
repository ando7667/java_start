package Java_DevKit.Lesson2.Task1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {
    private final MyWindow controller;
    private long lastFrameTime;
    public MainCanvas(MyWindow controller) {
        //setBackground(Color.BLUE);
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected  void paintComponent(Graphics g) {    // do {
        super.paintComponent(g);                    // something
        try {                                       // sleep
            Thread.sleep(16);                 //  16ms
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);  // useful
        lastFrameTime = System.nanoTime();
        repaint();                                  // while (true);
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom(){ return getHeight() - 1; }
}
