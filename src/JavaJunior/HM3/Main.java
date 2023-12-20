package JavaJunior.HM3;
/*
 * Написать класс с двумя методами:
 * 1. принимает объекты, имплементирующие интерфейс serializable, и сохраняющие их в файл. Название файл - class.getName() + "_" + UUID.randomUUID().toString()
 * 2. принимает строку вида class.getName() + "_" + UUID.randomUUID().toString() и загружает объект из файла и удаляет этот файл.
 *
 * Что делать в ситуациях, когда файла нет или в нем лежит некорректные данные - подумать самостоятельно.
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableEmployee employee1 = new SerializableEmployee("Николай", "Иванов", "10.05.1997", 1, 2, 3, "10.03.2020");
        SerializableEmployee employee2 = new SerializableEmployee("Алексей", "Серов", "23.09.1999", 2, 1, 3, "01.07.2021");
        String fname = SerializableEmployee.saveEmployee(employee1);
        System.out.printf("имя файла: %s\n",fname);
        System.out.println(SerializableEmployee.loadEmployee(fname));
        fname = SerializableEmployee.saveEmployee(employee2);
        System.out.printf("имя файла: %s\n",fname);
        System.out.println(SerializableEmployee.loadEmployee(fname));

    }
}
