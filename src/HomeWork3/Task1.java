// ============================================================================================================
// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
// Чтобы решить задачу, нужно уметь генерировать все перестановки с повторениями.
// Сначала разбираем эту задачу: https://leetcode.com/problems/combinations/.
// В задаче генерируются перестановки без повторений, нужно немного подкоректировать,
// чтобы были повторения, 11, 12 ... 20, 21... 30, 31...
//
// Как решать задачу. Выражение дается на вход в виде строки, может быть сколько угодно пробелов.
// Мы их все убираем. Метод replace. Переводим все в массив символов, чтобы могли вместо вопросов ставить символ,
// помним строки неизменяемы. Запоминаем индексы вопросов. Используем массив переменной длины для сохранения мест,
// где стоят вопросы. Далее начинаем генерировать комбинации. Длина комбинаций - кол-во вопросов. В момент,
// когда готова комбинация - запускаем функцию проверки, которая на место вопросов подставит числа из комбинации.
// После подстановки делаем из массива символов строку, разделяем ее по знаку =, перед этим заменив + на =.
// Получаем массив строк из трех элементов. Переводим эти элементы в числа и проверяем, что a + b == c.
// ------------------------------------------------------------------------------------------------------------

package HomeWork3;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static List<List<Integer>> ans;
    static char[] expressChar;
    static ArrayList<Integer> indexes = new ArrayList<>();
    static int count = 0;

    public static void combine(int k) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), k);
    }

    private static void helper(List<Integer> comb, int k) {
        if (comb.size() == k) {
            ans.add(new ArrayList<>(comb));
            // проверка комбинации
            checkComb(comb);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            comb.add(i);
            helper(comb, k);
            comb.remove(comb.size() - 1);
        }
    }

    public static void edExpression(String express) {
        // почистим строку от пробелов и занесем ее в символьный массив
        expressChar = express.replace(" ", "").toCharArray();
        for (int i = 0; i < expressChar.length; i++) {
            if (expressChar[i] == '=' || expressChar[i] == '+') {
                expressChar[i] = ';';
            }
            // запомним позиции вопросов в строке выражения
            if (expressChar[i] == '?') {
                indexes.add(i);
            }
        }
    }

    public static void checkComb(List<Integer> comb) {
        // делаем подстановку комбинации цифр в выражение
        for (int i = 0; i < comb.size(); i++) {
            expressChar[indexes.get(i)] = Character.forDigit(comb.get(i), 10);
        }
        // заносим в массив знчения переменных из выражения
        String[] expression = String.valueOf(expressChar).split(";");
        // извлекаем переменные выражения из массива и присваиваем переменным a b c
        int a = Integer.parseInt(expression[0]);
        int b = Integer.parseInt(expression[1]);
        int c = Integer.parseInt(expression[2]);
        // если равенство выполнилось, то выводим целое выражение в консоль
        if (a + b == c) {
            System.out.printf("Решение для данного выражения: %d + %d = %d\n", a, b, c);
            count++;
        }
    }

    public static void main(String[] args) {
        String inExpression = "2? + ?5 = 69";
        edExpression(inExpression);
        combine(2);
        if (count == 0) {
            System.out.println("Решение для данного выражения не нашлось!");
        }
    }
}
