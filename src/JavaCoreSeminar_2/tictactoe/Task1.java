package JavaCoreSeminar_2.tictactoe;

import java.sql.Array;
import java.util.Arrays;


public class Task1 {
    private static void printMsg(String msg) {
        System.out.println(msg);
    }

    private static int numberEvenArrayElements(int[] ar) {
        int count = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int diffBetweenMaxMinArrayElements(int[] ar) {

        int diff = -1;
        if (ar.length > 0) {
            int min = ar[0];
            int max = ar[0];

            for (int i = 0; i < ar.length; i++) {
                //поиск максимума
                if (ar[i] > max) {
                    max = ar[i];
                }
                // поиск минимума
                if (ar[i] < min) {
                    min = ar[i];
                }
            }

            diff = max - min;
        }
        return diff;
    }

    private static boolean twoAdjacentElementsEqualZero(int[] ar) {
        boolean bool = false;
        // если не пустой массив
        if (ar.length > 0) {
            for (int i = 0; i < ar.length - 1; i++) {
                // если не последний элемент
                if (i + 1 < ar.length) {
                    if (ar[i] == 0 && ar[i + 1] == 0) {
                        return true;
                    }
                }
            }
        }
        return bool;
    }

    public static void main(String[] args) {

        int arr[] = {2, 5, 6, 0, 0, 9, 4, -2, 8, 15, 23};

        System.out.printf("\nКоличество четных элементов массива: %d", numberEvenArrayElements(arr));
        System.out.printf("\nРазница между максимальным и минимальным элементами массива: %d", diffBetweenMaxMinArrayElements(arr));
        if (twoAdjacentElementsEqualZero(arr)) {
            printMsg("\nВ массиве ЕСТЬ два соседних элемента равные нулю");
        } else {
            printMsg("\nВ массиве НЕТ двух соседних элементов равных нулю");
        }
    }

}
