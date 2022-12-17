// ============================================================================================================
// 3 - Дан массив целых чисел (List<Integer>) найти минимальное, максимальное значения в этом массиве.
// ------------------------------------------------------------------------------------------------------------

package HomeWork3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static HomeWork3.Task2.fillArrayList;

public class Task3 {
    static List<Integer> array = new ArrayList<>();
    static List<Integer> status = new ArrayList<>();

    public static void minMaxInArray() {
        int min = array.get(0);
        int max = array.get(0);
        for (Integer i : array) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        status.add(min);
        status.add(max);
    }

    public static void main(String[] args) {
        fillArrayList(array, 30);
        System.out.println("Исходный список целых чисел:" + array);
        minMaxInArray();
        System.out.printf("минимум: %d, максимум: %d\n", status.get(0), status.get(1));
        System.out.println("Через методы пакета Collections max, min ->");
        System.out.printf("минимум: %d\n", Collections.min(array));
        System.out.printf("максимум: %d\n", Collections.max(array));
        System.out.println("Через методы пакета Collections sort ->");
        Collections.sort(array);
        System.out.printf("минимум: %d\n", array.get(0));
        System.out.printf("максимум: %d\n", array.get(array.size() - 1));

    }
}
