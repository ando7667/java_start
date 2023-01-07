package Seminar7_1;

public class RealNums_1 implements Nums {

    int start;
    int val;

    RealNums_1() {
        start = 0;
        val = 0;
    }

    @Override
    public int getNext() {
        val += 20;
        return val;
    }

    @Override
    public void reset() {
        start = 0;
        val = 0;
    }

    @Override
    public void setStart(int x) {
        start = x;
        val = x;
    }
}
