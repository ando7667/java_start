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

        int pol = convertPoleToInt(field, 3);
        System.out.println("pol= " + pol);
        saveIntToFile(pol);
        pol = loadFile();
        System.out.println("Считали из файла сохранения игры число: " + pol);
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
        char[][] gamepole = new char[size][size];


        return gamepole;
    }
}
