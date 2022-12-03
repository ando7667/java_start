//========================================================================
// https://leetcode.com/problems/flood-fill/ - заходим в данную клеточку
// и помечаем его и всех соседей заданным цветом
//------------------------------------------------------------------------

package HomeWork2;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        System.out.println("Перекрашенная картинка = " + Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int mask = image[sr][sc];
        if (mask != color) {
            fillCellColor(image, sr, sc, color, mask);
        }
        return image;
    }

    private static void fillCellColor(int[][] board, int i, int j, int color, int mask) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != mask)
            return;
        board[i][j] = color;
        fillCellColor(board, i + 1, j, color, mask);
        fillCellColor(board, i - 1, j, color, mask);
        fillCellColor(board, i, j + 1, color, mask);
        fillCellColor(board, i, j - 1, color, mask);
    }
}
