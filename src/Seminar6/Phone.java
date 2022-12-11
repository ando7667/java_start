package Seminar6;
// =====================================================================================================================
//1. Создайте класс Phone, который содержит переменные number, model и weight.
//2. Создайте три экземпляра этого класса.
//3. Выведите на консоль значения их переменных.
//4. Добавить в класс Phone методы: receiveCall, имеет один параметр – имя звонящего.
//   Выводит на консоль сообщение “Звонит {name}”. Метод 5. getNumber – возвращает номер телефона.
//   Вызвать эти методы для каждого из объектов.
//6. Добавить конструктор в класс Phone, который принимает на вход три параметра для инициализации переменных класса -
//      number, model и weight.
//7.  Добавить конструктор, который принимает на вход два параметра для инициализации переменных класса - number, model.
//8.  Добавить конструктор без параметров.
//9.  Вызвать из конструктора с тремя параметрами конструктор с двумя.
//10. Добавьте перегруженный метод receiveCall, который принимает два параметра - имя звонящего и номер телефона звонящего.
//    Вызвать этот метод.
//11. Создать метод sendMessage с аргументами переменной длины. Данный метод принимает на вход номера телефонов,
//    которым будет отправлено сообщение. Метод выводит на консоль номера этих телефонов.
// ---------------------------------------------------------------------------------------------------------------------

public class Phone {
    String number;
    String model;
    Integer weight;

    public Phone(String number, String model, int weight) {
//        this.number = number;
//        this.model = model;
        this(number, model);        // вызов конструктора с 2мя параметрами внутри коструктора с 3мя параметрами
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {

    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", model= " + model + '\'' +
                ", weight= " + weight +
                '}';
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String number) {
        System.out.println("Звонит " + name + " номер " + number);
    }

    public void sendMessage(String... numbers) {
        for (String number : numbers) {
            System.out.println("Номер для отправкиЖ " + number);
        }
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("89001584244", "Nokia", 110);
        Phone phone2 = new Phone("81105482549", "HTC", 120);
        Phone phone3 = new Phone("5943888", "Xiomi", 92);
        Phone phone4 = new Phone("56841111", "Aple");
        Phone phone5 = new Phone();

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.println(phone4);
        System.out.println(phone5);

        phone1.receiveCall("Alex");
        phone3.receiveCall("Anton", "1111111111");
        System.out.println(phone1.getNumber());
        phone1.sendMessage("222222222");
        phone2.sendMessage("33333333", "44444444");
        String[] numbers = {"5555555", "6666666", "77777777"};
        phone3.sendMessage(numbers);
    }
}
