package AlgoritmSem_2_1;

import java.util.Arrays;

public class QuickSort {
    int [] array;
    int counter;

    public QuickSort(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void sort(int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rigthPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        do {
            counter++;
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rigthPosition] > pivot) {
                rigthPosition--;
            }
            if (leftPosition <= rigthPosition) {
                if (leftPosition < rigthPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rigthPosition];
                    array[rigthPosition] = temp;
                }
                leftPosition++;
                rigthPosition--;
            }
//            System.out.println(counter + ": " + Arrays.toString(array));
        } while (leftPosition <= rigthPosition);

        if (leftPosition < endPosition) {
            sort(leftPosition, endPosition);
        }
        if (startPosition < rigthPosition) {
            sort(startPosition, rigthPosition);
        }
    }
    public void sort() {
        sort(0, array.length-1);
    }
}
