package Java_DevKit.HW3.task1;

import java.util.Arrays;

public class MyCollection <T>{
    private Object[] arr;
    private MyIterator<T> iterator;
    private int endPosition;

    MyCollection() {
        arr = new Object[0];
        iterator = new MyIterator<>((T[]) arr);
        endPosition = 0;
    }

    MyCollection(T t) {
        this();
        arr[endPosition++] = t;
    }


    public void add(T t) {
        Object[] tempArr = new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        tempArr[tempArr.length - 1] = t;
        arr = tempArr;
        iterator = new MyIterator<>((T[]) arr);
    }

    public void remove (T t) {
        Integer position = find(t);
        if (position != null) {
            Object[] tempArr = new Object[arr.length - 1];
            for (int i = 0; i < position; i++) {
                tempArr[i] = arr[i];
            }
            for (int i = position; i < arr.length - 1; i++) {
                tempArr[i] = arr[i + 1];
            }
            arr = tempArr;
        }
    }

    public Integer find(T t) {
        for (int i = 0; i < arr.length; i++) {
            if (t.equals(arr[i])) return i;
        }
        return null;
    }


    public void print () {
        System.out.println(Arrays.toString(arr));
    }

    public T next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }


}