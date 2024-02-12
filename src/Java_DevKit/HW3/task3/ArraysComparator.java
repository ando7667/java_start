package Java_DevKit.HW3.task3;

public class ArraysComparator {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длина массивов не совпадает.");
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!(arr1[i].equals(arr2[i]))) {
                return false;
            }
        }
        return true;
    }
}