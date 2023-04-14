package SeminarExeptions_1;

import java.sql.Array;
import java.util.Arrays;

/*
 Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 и возвращающий новый массив, каждый элемент которого равен сумме элементов
 двух входящих массивов в той же ячейке.
 Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 0, 3, 4, 7, 6};
        int[] array2 = new int[]{7, 8, 5, 4, 1, 2};
        System.out.println("значение:" + Arrays.toString(sumElementsInArray(array1, array2)));
    }

    public static int[] sumElementsInArray(int[] arr1, int[] arr2) {
        if ( arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разной длины !");
        }
        int[] arrout = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrout[i] = arr1[i] + arr2[i];
        }
        return arrout;
    }
}
