package Java_DevKit.HW1task4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerManagement extends JFrame {
    private static boolean isServerWorking;
    // параметры окна
    private static final int WIN_POSX = 400;
    private static final int WIN_POSY = 400;
    private static final int WIN_HEIGHT = 400;
    private static final int WIN_WIDTH = 400;
    private static final String WIN_NAME = "Управление Сервером VS-001";

    JButton btnStart = new JButton("Вкл");
    JButton btnStop = new JButton("Выкл");
    JButton btnExit = new JButton("Выход");
    JTextArea winMsg = new JTextArea();

    ServerManagement() {

        isServerWorking = false;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WIN_POSX, WIN_POSY);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setTitle(WIN_NAME);
        setResizable(false);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isServerWorking) {
                    // System.out.println("Сервер уже включен!");
                    winMsg.append("Сервер уже включен!\n");
                } else {
                    isServerWorking = true;
                    // System.out.println("Сервер включен!");
                    winMsg.append("Сервер включен!\n");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isServerWorking) {
                    // System.out.println("Сервер уже выключен!");
                    winMsg.append("Сервер уже выключен!\n");
                } else {
                    isServerWorking = false;
                   // System.out.println("Сервер выключен!");
                    winMsg.append("Сервер выключен!\n");
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Выход из программы");
                System.exit(0);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 3));
        panBottom.add(btnStart);
        panBottom.add(btnStop);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        setLayout(new GridLayout(2, 1));
        add(winMsg);
        setVisible(true);
    }

}
