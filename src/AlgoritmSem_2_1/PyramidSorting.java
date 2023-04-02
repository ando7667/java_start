package AlgoritmSem_2_1;

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
        // построение кучи
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftingHeap(array.length, i);
        }
        // извлекаем элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            // перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // просеем уменьшенную кучу
            siftingHeap(i, 0);
            counter++;
        }
    }

    private void siftingHeap(int heapSize, int rootIndex) {
        int largest = rootIndex;            // инициализируем наибольший элемент корневым элементом
        int leftChild = 2 * rootIndex + 1;  // левый потомок
        int rigtChild = 2 * rootIndex + 2;  // правый потомок

        // если левый потомок больше наибольшего элемента
        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // если правый потомок больше наибольшего элемента
        if (rigtChild < heapSize && array[rigtChild] > array[largest]) {
            largest = rigtChild;
        }

        // если наибольший элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // преобразуем в двоичную кучу затронутое поддерево
            siftingHeap(heapSize, largest);
        }
    }
}
