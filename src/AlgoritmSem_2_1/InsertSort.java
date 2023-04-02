package AlgoritmSem_2_1;

import java.lang.reflect.Array;
import java.util.Arrays;

// сортировак вставкой
public class InsertSort {

    int[] array;
    int counter;

    public InsertSort(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void sort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                counter++;
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
 //           System.out.println(i + ": " + Arrays.toString(array));
        }
    }
}
