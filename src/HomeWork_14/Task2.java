package HomeWork_14;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,0,7,5,3,66,32};
        func1(array);
    }

    public static void func1(int[] intArray){

        //Задание 2
        // работаем с массивом, поэтому нужно добавить обработку исключений на null и
        // контроль выхода индекса за пределы массива

        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

}
