package AlgoritmSem_2_1;

import java.util.Arrays;

// сортировка выбором
public class DirectSort {
    int[] array;
    int counter;

    public DirectSort(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void sort() {
        for (int i = 0; i<array.length-1;i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
            counter++;
//            System.out.println(i+": "+ Arrays.toString(array));
        }
    }
}
