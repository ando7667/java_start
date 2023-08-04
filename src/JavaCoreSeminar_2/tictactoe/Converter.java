package JavaCoreSeminar_2.tictactoe;

import java.io.IOException;

import static JavaCoreSeminar_2.tictactoe.FileOperation.loadFile;
import static JavaCoreSeminar_2.tictactoe.FileOperation.saveIntToFile;
import static JavaCoreSeminar_2.tictactoe.Game.*;

public class Converter {

    // для теста
    public static void main(String[] args) throws IOException {
        char[][] field = new char[][]{
                {'O', 'X', '.'},
                {'.', '.', '.'},
                {'X', 'O', 'O'}};

        int pol = convertPoleToInt(field, SIZE_X);
        System.out.println("pol= " + pol);
        saveIntToFile(pol);
        pol = loadFile();
        System.out.println("Считали из файла сохранения игры число: " + pol);
        char[][] field2 = convertIntToPole(pol, SIZE_X);
        printField2(field2);
    }

    public static int convertPoleToInt(char[][] gamepole, int size) {
        int pole = 0;
        int value = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                char symbol = gamepole[x][y];
                switch (symbol) {
                    case DOT_EMPTY -> value = 0;
                    case DOT_HUMAN -> value = 1;
                    case DOT_AI -> value = 2;
                    case DOT_RESERV -> value = 3;
                }
                if (pole == 0) {
                    pole = value;
                } else {
                    pole = (pole << 2) + value;
                }
            }
        }
        return pole;
    }

    public static char[][] convertIntToPole(int pole, int size) {
        char[] symbols = {DOT_EMPTY, DOT_HUMAN, DOT_AI, DOT_RESERV};
        char[][] gamepole = new char[size][size];
        for (int i = size-1; i >= 0; i-- ){
            for (int j = size-1; j >= 0; j--) {
                gamepole[i][j] = symbols[pole&3];
                pole = pole >> 2;
            }
        }
        return gamepole;
    }

    static void printField2(char[][] field) {
        System.out.print("\n+");
        for (int i = 0; i < SIZE_X * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE_X; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < SIZE_X; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < SIZE_X * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
