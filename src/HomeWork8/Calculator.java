package HomeWork8;

import HomeWork8.Actions.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<Integer, Action> operationMap = new HashMap<>();

    // конструктор с инициализацией мапы ключей из меню и связанных опреций
    Calculator() {
        operationMap.put(1, new Addition());
        operationMap.put(2, new Subtraction());
        operationMap.put(3, new Multiplication());
        operationMap.put(4, new Division());
    }

    double makeCalculation(double operand1, double operand2, int operation) {
        // получение класса операции из мапы и обработка недопустимой операции(NoActionFound(operation))
        Action operationMapValue = operationMap.getOrDefault(operation, new NoActionFound(operation));
        // возвращаем результат вычисления
        return operationMapValue.calculateResult(operand1, operand2);
    }
}
