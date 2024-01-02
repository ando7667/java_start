package Java_DevKit.HW6.src.main.java.org.ignatov;

public class Door {
    private final boolean CAR = true;
    private final boolean GOAT = false;
    private final boolean CLOSE = true;
    private final boolean OPEN = false;
    private boolean val;
    private boolean close;

    Door() {
        this.val = GOAT;
        this.close = CLOSE;
    }

    public boolean isVal() {
        return val;
    }

    public void setVal(boolean val) {
        this.val = val;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }
    @Override
    public String toString() {
        return ((this.isVal())?"авто":"коза") + " " + ((this.isClose())?"закрыта":"открыта");
    }
}
