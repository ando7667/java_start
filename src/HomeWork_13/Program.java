package HomeWork_13;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] array1 = new int[]{10, 10, 30, 4, 20, 6};
        int[] array2 = new int[]{2, 1, 5, 4, 0, 2};
        System.out.println("значение:" + Arrays.toString(diffElementsInArray(array1, array2)));
        System.out.println("значение:" + Arrays.toString(divElementsInArray(array1, array2)));
    }

    public static int[] diffElementsInArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разной длины !");
        }
        int[] arrout = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arrout[i] = arr1[i] - arr2[i];
        }
        return arrout;
    }

    public static int[] divElementsInArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы разной длины !");
        }
        int[] arrout = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Выполнение метода остановлено, деление на 0!\n" + (i + 1) + "й элемент во втром массиве = 0 !");
            }
            arrout[i] = arr1[i] / arr2[i];
        }
        return arrout;
    }
}

