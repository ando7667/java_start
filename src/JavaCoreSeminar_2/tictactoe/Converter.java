package JavaCoreSeminar_2.tictactoe;

import static JavaCoreSeminar_2.tictactoe.Game.*;

public class Converter {

    public static void main(String[] args) {
        char[][] field = new char[][]{
                {'O', 'X', '.' },
                {'.', '.', '.'},
                {'X', 'O', 'O'}};

        int pol = convertPoleToInt(field,3);
        System.out.println("pol= " + pol);
    }

    public static int convertPoleToInt(char[][] gamepole, int size) {
        int pole = 0;
        int value = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                char symbol = gamepole[x][y];
                switch (symbol){
                    case DOT_EMPTY:
                        value = 0;
                        break;
                    case DOT_HUMAN:
                        value = 1;
                        break;
                    case DOT_AI:
                        value = 2;
                        break;
                }
                if (pole == 0) {
                    pole = value;
                }else {
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
