package  Java_DevKit.Lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow  extends JFrame {
        private static final int WINDOW_HEIGHT = 555;
        private static final int WINDOW_WIDTH = 500;
        private static final int WINDOW_POSX = 600;
        private static final int WINDOW_POSY = 200;
        private static final String WINDOW_NAME = "Игра в крестики-нолики";

        JButton btnStart = new JButton("Новая игра");
        JButton btnExit = new JButton("Выход");
        GameMap map;
        SettingsWindow settings;

        GameWindow() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(WINDOW_POSX, WINDOW_POSY);
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            setTitle(WINDOW_NAME);
            setResizable(false);

            settings = new SettingsWindow(this);
            map = new GameMap(settings.sliderSize.getValue(), settings.sliderSize.getValue(), settings.sliderWin.getValue());
            System.out.printf("вызов gameMap - x = %d, Y= %d, len_win=%d", settings.sliderSize.getValue(), settings.sliderSize.getValue(), settings.sliderWin.getValue());

            btnExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    settings.setVisible(true);
                }
            });

            JPanel panBottom = new JPanel(new GridLayout(1, 2));
            panBottom.add(btnStart);
            panBottom.add(btnExit);
            add(panBottom, BorderLayout.SOUTH);
            add(map);
            setVisible(true);
        }

    void startNewGame(int mode, int fSzX, int fSxY, int wLen) {
            map.startNewGame(mode, fSzX, fSxY, wLen);
    }
}

