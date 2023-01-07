package Seminar7_1;

public class RealNums implements Nums {

    int start;
    int val;
    int prev;

    RealNums() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public int getNext() {
        prev = val;
        val += 2;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
        prev = -2;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
        prev = x - 2;
    }
}
