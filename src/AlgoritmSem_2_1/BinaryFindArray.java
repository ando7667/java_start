package AlgoritmSem_2_1;

// поиск элемента в массиве бинарным поиском / O(log n)
public class BinaryFindArray {
    int[] array;
    int counter;

    public BinaryFindArray(int[] arr) {
        this.array = arr;
        this.counter = 0;
    }

    public int getCounter() {
        return this.counter;
    }

    public int find(int value, int min, int max) {

        int midpoint;
        counter++;

        if (max < min) {
            return -1;
        }else {
            midpoint = (max - min)/2 +min;
        }
        if (array[midpoint]< value) {
            return find(value, midpoint+1, max);
        }else {
            if (array[midpoint]> value) {
                return find(value, min, midpoint - 1 );
            }else {
                return midpoint;
            }
        }
    }

    // перегрузим функцию для одного параметра
    public int find(int value) {
        return find(value, 0, array.length-1);
    }
}
