package HomeWork8.Actions;

import HomeWork8.Action;
import HomeWork8.Program;

import java.util.logging.Level;

public class Division implements Action {
    @Override
    public double calculateResult(double left, double right) {
        if (right == 0) {
            System.out.println("Деление на ноль!");
            return 0;
        }
        return left / right;
    }
}