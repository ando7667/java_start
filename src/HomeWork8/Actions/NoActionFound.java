package HomeWork8.Actions;

import HomeWork8.Action;

import java.util.InputMismatchException;

public class NoActionFound implements Action {
    private int sign;
    public NoActionFound(int sign){
        this.sign = sign;
    }

    @Override
    public double calculateResult(double left, double right) {
        throw new InputMismatchException("Invalid operator sign: " + sign);
    }
}
