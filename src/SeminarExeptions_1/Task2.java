package SeminarExeptions_1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
если вместо массива пришел null, метод вернет -3
придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
Напишите метод, в котором реализуйте взаимодействие с пользователем.
То есть, этот метод запросит искомое число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю.
Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,6,4,2,1,3,0};
        int num = 6;
        int len =6;
        System.out.println("значение:" + searchNumberInArray(array, num, len));
    }

    public static int searchNumberInArray(int[] arr, int num, int len) {

        if(arr == null || arr.length == 0){
            return -3;
        }
        if(arr.length < len){
            return -1;
        }
        for (int i =0; i< arr.length; i++){
            if(arr[i] == num) {
                return i;
            }
        }
        return -2;
    }

}
