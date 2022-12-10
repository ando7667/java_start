// =========================================================================
// https://leetcode.com/problems/walls-and-gates/
// Input: rooms = [[2147483647,-1,0,2147483647],
//                 [2147483647,2147483647,2147483647,-1]
//                 [2147483647,-1,2147483647,-1],
//                 [0,-1,2147483647,2147483647]]
// Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// Input: rooms = [[-1]]
// Output: [[-1]]
// поиск кратчайшего пути ( в ширину)
// ------------------------------------------------------------------------

package Seminar4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Task1 {
    static final int EMPTY = Integer.MAX_VALUE;
    static final int GATE = 0;
    static final int WALL = -1;
    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));

    }

    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == GATE) {
                    // добавляем в очередь на чальные координаты поиска ( от ворот )
                    // до них мы ищем кратчайший путь
                    q.add(new int[]{row, col});

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
                if (newRow < 0 || newCol < 0 || newRow >= rooms.length || newCol >= rooms[0].length || rooms[newRow][newCol] != EMPTY) {
                    // если условие не выполняется, то переходим к следующему соседу
                    continue;
                }
                // заносим в соседа расстояние от него до текущей клетки ( на 1 больше )
                rooms[newRow][newCol] = rooms[curRow][curCol] + 1;
                // добавим в очередь координаты этого соседа
                q.add(new int[]{newRow, newCol});
            }
        }
    }
}
