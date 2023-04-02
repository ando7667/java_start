package AlgoritmSem_2_1;

import java.util.Arrays;

// пузырьковая сортировка
public class BubbleSort {
    int[] array;
    int counter;

    BubbleSort(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void sort() {
        int size = array.length;
        boolean finish;
        do {
            finish = true;
            for (int j = 0; j < size-1; j++) {
                counter++;
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    finish = false;
                }
            }
//            System.out.println(" > "+ Arrays.toString(array));

        }while (!finish);

    }
}