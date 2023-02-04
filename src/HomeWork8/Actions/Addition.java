package HomeWork8.Actions;

import HomeWork8.Action;

public class Addition implements Action {
    @Override
    public double calculateResult(double left, double right) {
        return left + right;
    }
}