package Java_DevKit.HW3.task3;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3};
        Integer[] arr2 = new Integer[]{1, 2, 3};

        String[] arr3 = new String[]{"a", "b", "e"};
        String[] arr4 = new String[]{"a", "b", "c"};

        System.out.println(ArraysComparator.compareArrays(arr1, arr2));
        System.out.println(ArraysComparator.compareArrays(arr3, arr4));
    }
}