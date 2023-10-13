package Java_DevKit.Lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    private static final Random RANDOM =new Random();
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;

    private final int DOT_PADDING = 5;
    private int gameOverType;
    private boolean isGameOver;
    private boolean isInitialized;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил ИИ!";
    private static final String MSG_DRAW = "Ничья!";
    private int fieldSizeY;
    private int fieldSizeX;
    private int len_win;
    private int[][] field;

    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    GameMap(int sizeX, int sizeY, int len_win) {
        this.fieldSizeX = sizeX;
        this.fieldSizeY = sizeY;
        this.len_win = len_win;
        setBackground(Color.GRAY);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY);
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    void startNewGame(int mode, int fSzX, int fSxY, int wLen) {
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSxY, wLen);
        this.fieldSizeX = fSzX;
        this.fieldSizeY = fSxY;
        this.len_win = wLen;
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) return;
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        cellHeight = panelHeight / this.fieldSizeX;
        cellWidth = panelWidth / this.fieldSizeY;

        g.setColor(Color.BLACK);
        for (int h = 0; h < this.fieldSizeX; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < this.fieldSizeY; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < this.fieldSizeY; y++) {
            for (int x = 0; x < this.fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);

                } else if(field[y][x] == AI_DOT) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);

                } else {
                    throw new RuntimeException("Unexpectesd value " + field[y][x] +
                            "in cell: x=" + x + " y=" +y);
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }

    void initMap() {
        field = new int[this.fieldSizeY][this.fieldSizeX];
        for (int i = 0; i < this.fieldSizeY; i++) {
            for (int j = 0; j < this.fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < this.fieldSizeX && y >= 0 && y < this.fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x,y;
        do {
            x = RANDOM.nextInt(this.fieldSizeX);
            y = RANDOM.nextInt(this.fieldSizeY);
        } while (!isEmptyCell(x,y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(int symbol, int len_check) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (checkLine(x, y, 1, 0, len_check, symbol)) return true;
                if (checkLine(x, y, 0, 1, len_check, symbol)) return true;
                if (checkLine(x, y, 1, 1, len_check, symbol)) return true;
                if (checkLine(x, y, 1, -1, len_check, symbol)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int dx, int dy, int len_check, int symb) {
        int max_x = x + (len_check - 1) * dx;
        int max_y = y + (len_check - 1) * dy;
        if (!isValidCell(max_x, max_y)) return false;
        for (int i = 0; i < len_check; i++) {
            if (field[y + i * dy][x + i * dx] != symb) return false;
        }
        return true;
    }


    private boolean isMapFull() {
        for (int i = 0; i < this.fieldSizeY; i++) {
            for (int j = 0; j < this.fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot, this.len_win)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }
}
