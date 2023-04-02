package AlgoritmSem_2_1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {

        int[] array = new int[] { 7, 2, 4, 8, 6, 0, 1, 9, 3, 2, 5, 0, 2 };

        System.out.println("сортировка вставкой");
        InsertSort arr = new InsertSort(array);
        System.out.println(Arrays.toString(array));
        arr.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arr.getCounter());

        System.out.println("\nсортировка пузырьковая");
        array = new int[] { 7, 2, 4, 8, 6, 0, 1, 9, 3, 2, 5, 0, 2 };
        System.out.println(Arrays.toString(array));
        BubbleSort arrb = new BubbleSort(array);
        arrb.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arrb.getCounter());

        System.out.println("\nсортировка выбором");
        array = new int[] { 7, 2, 4, 8, 6, 0, 1, 9, 3, 2, 5, 0, 2 };
        System.out.println(Arrays.toString(array));
        DirectSort arrd = new DirectSort(array);
        arrd.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arrd.getCounter());

        System.out.println("\nпоследовательный поиск");
        FindArray arrf = new FindArray(array);
        int val = arrf.find(21);
        if (val >= 0) {
            System.out.println("число найдено, позиция :" + val);
        }else {
            System.out.println("данного числа нет");
        }
        System.out.println("проходов: "+ arrf.getCounter());

        System.out.println("\nбинарный поиск");
        BinaryFindArray arrbf = new BinaryFindArray(array);
        int valbf = arrbf.find(21);
        if (valbf >= 0) {
            System.out.println("число найдено, позиция :" + val);
        }else {
            System.out.println("данного числа нет");
        }
        System.out.println("проходов: "+ arrbf.getCounter());

        System.out.println("\nБыстрая сортировка");
        array = new int[] { 7, 2, 4, 8, 6, 0, 1, 9, 3, 2, 5, 0, 2 };
        System.out.println(Arrays.toString(array));
        QuickSort arrq = new QuickSort(array);
        arrq.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arrq.getCounter());

        System.out.println("\nПирамидальная сортировка");
        array = new int[] { 7, 2, 4, 8, 6, 0, 1, 9, 3, 2, 5, 0, 2 };
        System.out.println(Arrays.toString(array));
        PyramidSorting arrp = new PyramidSorting(array);
        arrp.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arrp.getCounter());

    }
}
