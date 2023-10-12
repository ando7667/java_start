package Java_DevKit.Lesson1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 240;
    private static final int WINDOW_WIDTH = 350;
    public static int sliderSizeValue = 3;
    public static int sliderWinValue =3;
    public static boolean modeValue = false;

    JLabel labelMode = new JLabel("Выберите режим игры:");

    JRadioButton humanVsHumanBtn = new JRadioButton("Человек против человека",true);
    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера",false);

    ButtonGroup topBtnGroup = new ButtonGroup();

    JLabel labelSize = new JLabel(String.format("Установите размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3, 10, sliderSizeValue);

    JLabel labelWin = new JLabel(String.format("Установите длину для победной цепочки: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3, 10, sliderWinValue);

    JPanel grid = new JPanel(new GridLayout(4, 1));

    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel topBtn = new JPanel(new GridLayout(2, 1));
    JPanel middle = new JPanel(new GridLayout(2,1));
    JPanel bottom = new JPanel(new GridLayout(2,1));
    JButton btnStart = new JButton("Запуск игры");
    SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Настройки игры");
        topBtnGroup.add(humanVsHumanBtn);
        topBtnGroup.add(humanVsAi);
        topBtn.add(humanVsHumanBtn);
        topBtn.add(humanVsAi);

        top.add(labelMode);
        top.add(topBtn);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Установленный размер поля:: %d", sliderSizeValue));
            }
        });
        middle.add(labelSize);
        middle.add(sliderSize);

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelWin.setText(String.format("Установленная длина: %d", sliderWinValue));
            }
        });

        bottom.add(labelWin);
        bottom.add(sliderWin);

        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(btnStart);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, sliderSize.getValue(), sliderSize.getValue(), sliderWin.getValue());
                setVisible(false);
            }
        });

        add(grid);
    }
}
