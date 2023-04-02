package AlgoritmSem_2_1;

// поиск елемента в массиве простым перебором / O(n)
public class FindArray {
    int[] array;
    int counter;

    public FindArray(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public int find(int value) {
        for (int i = 0; i < array.length; i++) {
            counter++;
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
