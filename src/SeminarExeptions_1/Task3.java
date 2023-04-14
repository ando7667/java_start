package SeminarExeptions_1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения:
метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */
public class Task3 {
    public static void main(String[] args) {
            int[][] array = new int[][]{{1, 0, 1, 1},
                                        {0, 1, 1, 1},
                                        {1, 1, 1, 1},
                                        {1, 1, 1, 1}
                                        };
            int num = 6;
            int len = 6;
            System.out.println("значение:" + sumElementsBinInArray(array));
        }

        public static int sumElementsBinInArray ( int[][] arr){
            int sum = 0;
            if (arr == null || arr.length == 0) {
                throw new RuntimeException("Массив не существует или пустой");
            }
            if (arr.length != arr[0].length) {
                throw new RuntimeException("Массив не квадратный!");
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[1].length; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != 1) {
                        throw new RuntimeException("Массив не бинарный!");
                    } else {
                        sum += arr[i][j];
                    }
                }
            }
            return sum;
        }

}