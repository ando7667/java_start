// ===============================================================
// https://leetcode.com/problems/01-matrix/  - ищем от нулей.
// Нужно завести двумерный массив типа boolean,
// для отметки посещенных клеток. Шаблон как в задаче с семинара
// Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
// Output: [[0,0,0],[0,1,0],[0,0,0]]
//
// Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
// Output: [[0,0,0],[0,1,0],[1,2,1]]
// ----------------------------------------------------------------

package HomeWork4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task1 {
    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}};
    static boolean[][] check = new boolean[matrix.length][matrix[0].length];

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (mat[row][col] == 0) {
                    // добавляем в очередь начальные координаты поиска ( от нуля )
                    // до нуля мы ищем кратчайший путь
                    q.add(new int[]{row, col});
                    // пометим ячейку ка проверенную
                    check[row][col] = true;
                }
            }
        }

        // обходим всех соседей для точек из очереди
        while (!q.isEmpty()) {
            // берем текущую координату
            int[] curPoint = q.poll();
            int curRow = curPoint[0];
            int curCol = curPoint[1];
            // обходим всех соседей для текущей координты
            for (int[] direction : DIRECTIONS) {
                // получаем координаты для соседа
                int newRow = curRow + direction[0];
                int newCol = curCol + direction[1];
                // проверяем границы комнаты и содержимое ячейки
                if (newRow < 0 || newCol < 0 || newRow >= mat.length || newCol >= mat[0].length || check[newRow][newCol]) {
                    // если условие не выполняется, то переходим к следующему соседу
                    continue;
                }
                // заносим в соседа расстояние от него до текущей клетки ( на 1 больше )
                mat[newRow][newCol] = mat[curRow][curCol] + 1;
                // пометим ячейку ка проверенную
                check[newRow][newCol] = true;
                // добавим в очередь координаты этого соседа
                q.add(new int[]{newRow, newCol});
            }
        }
        return mat;
    }
}
