package SeminarExeptions_1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
Если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки, иначе - длину массива.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,6,4,2,1,3,0};
        int len = 11;
        System.out.println("длина масства:" + checkArray(array, len));
    }

    public static int checkArray(int[] arr, int len) {

        if(arr.length < len){
            return -1;
        }
        return arr.length;
    }
}
