// ===================================================================================
// 2 - Дан массив целых чисел (List<Integer) удалить из него четные числа.
// Посмотрите на метод removeAll (можно сохранить все четные значения в другой список
// и передать его в removeAll или используйте итератор.
// -----------------------------------------------------------------------------------

package HomeWork3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    static List<Integer> array = new ArrayList<>();

    public static void fillArrayList(List<Integer> arr, int count) {
        Random rnd = new Random();
        for (int i = 0; i < count; i++) {
            arr.add(rnd.nextInt(1, 99));
        }
    }

    public static List<Integer> removeOddElements(List<Integer> arr) {
        List<Integer> arrn = new ArrayList<>();
        for (Integer integer : arr) {
            if (integer % 2 == 0) {
                arrn.add(integer);
            }
        }
        arr.removeAll(arrn);
        return arr;
    }

    public static void main(String[] args) {
        fillArrayList(array, 30);
        System.out.println("Исходный список целых чисел:" + array);
        System.out.println("Без четных элементов:" + removeOddElements(array));

    }
}
