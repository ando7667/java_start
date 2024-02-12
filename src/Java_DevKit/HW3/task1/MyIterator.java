package Java_DevKit.HW3.task1;

import java.util.Iterator;

public class MyIterator <T> implements Iterator<T>, Iterable<T> {
    private final T[] arr;
    private int index;

    MyIterator(T[] arr) {
        this.arr = arr;
        index = 0;
    }

    public boolean hasNext() {
        return (index < arr.length && arr[index] != null);
    }

    public T next() {
        if (hasNext()) {
            return arr[index++];
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(arr);
    }

}