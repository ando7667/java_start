package HomeWork10;

import java.util.Random;

public class GenArray {
    int[] array;

    public void genArray(int min, int max) {
        array = new int[max - min];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(min, max);
        }
    }

    public  void genArray(int max) {
        genArray(0,max);

    }
    public int[] getArray() {
        return this.array;
    }
}
