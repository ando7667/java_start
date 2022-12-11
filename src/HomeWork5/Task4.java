// =========================================================================================
// https://leetcode.com/problems/roman-to-integer/
//  сделать мапу <Символ -> Значение>. Если текущий символ < правого соседа,
//  тогда мы его вычитаем, иначе прибавляем.
// Input: s = "III"
// Output: 3
// Input: s = "LVIII"
// Output: 58
// Input: s = "MCMXCIV"
// Output: 1994
// -----------------------------------------------------------------------------------------

package HomeWork5;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {

        String s = "MCMXCIV";

        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        // заносим в мапу значения символов
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        // цикл по сиволам строки s до предпоследнего симола,
        // тк для последнего символа не будет следующего символа для сравнения
        // в строке 46
        for (int i = 0; i < s.length() - 1; i++) {
            // если значение текущего символ в строке большему или равен значению следующего символа,
            // то к сумме прибавляем значение текущего символа, если меньше , то вычитаем
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                sum += map.get(s.charAt(i));
            } else {
                sum -= map.get(s.charAt(i));
            }
        }

        // добавляем к сумме значение последнего символа строки
        sum += map.get(s.charAt(s.length() - 1));

        return sum;
    }
}
