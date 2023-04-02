package HomeWork10;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {

        int[] array;
        GenArray arr = new GenArray();
        arr.genArray(100);
        array = arr.getArray();
        System.out.println("\nПирамидальная сортировка");
        System.out.println(Arrays.toString(array));
        PyramidSorting arrp = new PyramidSorting(array);
        arrp.sort();
        System.out.println(Arrays.toString(array));
        System.out.println("проходов: "+ arrp.getCounter());

    }
}