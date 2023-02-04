package HomeWork8;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestUnit {
    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // сложение
        assertEquals(89.0, calc.makeCalculation(12.0, 77.0, 1));
        assertEquals(-65.0, calc.makeCalculation(12.0, -77.0, 1));
        // вычитание
        assertEquals(18.0, calc.makeCalculation(36.0, 18.0, 2));
        assertEquals(54.0, calc.makeCalculation(36.0, -18.0, 2));
        // умножение
        assertEquals(75.0, calc.makeCalculation(15.0, 5.0, 3));
        assertEquals(0.0, calc.makeCalculation(0.0, 5.0, 3));
        // деление
        assertEquals(5.0, calc.makeCalculation(125.0, 25.0, 4));
        assertEquals(0.0, calc.makeCalculation(125.0, 0.0, 4));
        // несуществующая операция
        assertEquals(0.0, calc.makeCalculation(125.0, 1.0, 5));

        System.out.println("Все тесты пройдены успешно!");

    }
}
