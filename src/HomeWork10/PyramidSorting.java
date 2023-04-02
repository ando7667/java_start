package HomeWork10;

public class PyramidSorting {
    int[] array;
    int counter;

    public PyramidSorting(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public void sort() {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftingHeap(array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            siftingHeap(i, 0);
        }
    }

    private void siftingHeap(int heapSize, int rootIndex) {
        int maxElement = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rigtChild = 2 * rootIndex + 2;
        counter++;

        if (leftChild < heapSize && array[leftChild] > array[maxElement]) {
            maxElement = leftChild;
        }

        if (rigtChild < heapSize && array[rigtChild] > array[maxElement]) {
            maxElement = rigtChild;
        }

        if (maxElement != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[maxElement];
            array[maxElement] = temp;
            siftingHeap(heapSize, maxElement);
        }
    }
}

