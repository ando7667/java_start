package Java_DevKit.HW3.task1;

/* ================================================================================================

 1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
    чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 2. Написать класс Калькулятор (необобщенный), который содержит обобщенные статические методы:
    sum(), multiply(), divide(), subtract(). Параметры этих методов – два числа разного типа,
    над которыми должна быть произведена операция.
 3. Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true, если они одинаковые,
    и false в противном случае. Массивы могут быть любого типа данных,
    но должны иметь одинаковую длину и содержать элементы одного типа.
 4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.55
    Класс должен иметь методы getFirst(), getSecond() для получения значений пары,1
    а также переопределение метода toString(), возвращающее строковое представление пары.
 ================================================================================================ */
public class Main {
    public static void main(String[] args) {
        MyCollection<Integer> intArr = new MyCollection<>();

        intArr.add(10);
        intArr.add(5);
        intArr.add(8);
        intArr.print();
        intArr.remove(5);
        intArr.add(4);
        intArr.remove(5);

        System.out.println(intArr.next());
        System.out.println(intArr.hasNext());
        System.out.println(intArr.next());
        System.out.println(intArr.next());
        System.out.println(intArr.hasNext());
        System.out.println(intArr.next());

        intArr.print();


        MyCollection<String> strArr = new MyCollection<>();
        strArr.add("one");
        strArr.add("two");
        strArr.add("three");
        strArr.print();
        strArr.remove("one");
        strArr.print();
        System.out.println(strArr.next());
        System.out.println(strArr.hasNext());
    }
}