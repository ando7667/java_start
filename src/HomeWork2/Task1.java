//==========================================================================
// https://leetcode.com/problems/max-area-of-island/ площадь острова = 1 + площадь его соседей.
// Подумайте о том, что два раза заходить не надо в клеточку.
// --------------------------------------------------------------------------
package HomeWork2;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        System.out.println("Наибольший остров = " + maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int squareMax = 0;
        int square;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1 && !visited[i][j]) {
                    square = mask(grid, i, j, visited);
                    if (squareMax < square) {
                        squareMax = square;
                    }
                }
        return squareMax;
    }

    private static int mask(int[][] board, int i, int j, boolean[][] visited) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == 0 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int count = 1;
        count += mask(board, i + 1, j, visited);
        count += mask(board, i - 1, j, visited);
        count += mask(board, i, j + 1, visited);
        count += mask(board, i, j - 1, visited);
        return count;
    }
}
