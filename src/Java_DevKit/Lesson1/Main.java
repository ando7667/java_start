package Java_DevKit.Lesson1;

// Задание 1 – добавить на экран компоновщик-сетку с одним столбцом и
// добавить над существующей кнопкой следующие компоненты в заданном порядке: JLabel с
// заголовком «Выберите режим игры», сгруппированные в ButtonGroup
// переключаемые JRadioButton с указанием режимов «Человек против компьютера» и
// «Человек против человека», JLabel с заголовком «Выберите размеры
// поля», JLabel с заголовком «Установленный размер поля:», JSlider со значениями 3..10,
// JLabel с заголовком «Выберите длину для победы», JLabel с заголовком «Установленная длина:»,
// JSlider со значениями 3..10.


public class Main {
    public static void main(String[] args) {
        new GameWindow();
        System.out.println("Method main() is over");
    }
}