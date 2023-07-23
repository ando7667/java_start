package SeminarExeptions_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UI {
    static Scanner scan = new Scanner(System.in);

    // требуемое количество параметров в строке ввода
    static int countData = User.class.getDeclaredFields().length;

    static String[] inpData;

    /**
     * Метод для вывода сообщения пользователю
     * и получения от него строки
     *
     * @param msg строка сообщения
     * @return введенная строка
     */
    public static String InputString(String msg) {

        System.out.printf(msg);
        return scan.nextLine();
    }

    /**
     * Метод для преобразования строки в длинное целое
     *
     * @param phone номер телефона как строка
     * @return номер телефона в long представлении
     * @throws InputException возникает исключение, если строка не соответствует требованиям
     */
    public static long checkInt(String phone) throws InputException, NumberFormatException {
        long val = 0;
        String regex = "^[0-9]*";
        if (phone == null || phone.isEmpty()) {
            throw new InputException("Поле Телефон пустое!");
        }
        if (!phone.matches(regex)) {
            throw new InputException("Ввели неправильно номер телефона!");
        }
        try {
            val = Long.parseLong(phone);
        } catch (NumberFormatException ex) {
            throw new InputException("\nВвели неправильный номер телефона!");
        }
        return val;
    }

    /**
     * Проверяет строку на соотвествие шаблону
     *
     * @param inpString проверяемая строка
     * @return возвращает проверяемую строку, если она соответсвует шаблону
     * @throws InputException возникает исключение, если строка не соответствует шаблону
     */
    public static String checkString(String inpString) throws InputException {
        String regex = "^[А-Я][а-я]*";
        if (inpString == null || inpString.isEmpty()) {
            throw new InputException("Одно из полей ФИО пустое!");
        }
        if (!inpString.matches(regex)) {
            throw new InputException("Неправильно введено ФИО!");
        }
        return inpString;
    }

    /**
     * проверяет строку на соотвествие символу m или f
     *
     * @param inpString проверяемая строка
     * @return возвращает символ m или f
     * @throws InputException возникает исключение, если строка не соответствует требованиям
     */
    public static char checkChar(String inpString) throws InputException {
        if (inpString == null || inpString.isEmpty()) {
            throw new InputException("Полe Пол человека пустое!");
        }
        if (inpString.length() > 1) {
            throw new InputException("Полe Пол человека содержит слишком много символов!");
        }
        char ch = inpString.charAt(0);
        if (ch != 'm' && ch != 'f') {
            throw new InputException("Пол человека задан неверно!");
        }
        return ch;
    }

    /**
     * Метод проверки правильности ввода Даты по шаблону dd.MM.yyyy
     *
     * @param str проверяемая строка
     * @throws InputException возникает исключение, если строка не соответствует требованиям
     */
    static String checkValidDate(String str) throws InputException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String regex = "^(((0[1-9]|[1-2][0-9]|3[0-1]).(0[13578]|(10|12)))|((0[1-9]|[1-2][0-9]).02)|((0[1-9]|[1-2][0-9]|30).(0[469]|11))).[0-9]{4}$";

        try {
            if (str == null || str.isEmpty()) {
                throw new InputException("В поле Дата рождения пусто");
            }
            if (!str.matches(regex)) {
                throw new InputException("Дата рождения введена неверно!");
            }
            format.parse(str);
            return str;
        } catch (ParseException e) {
            throw new InputException("Не могу отпарсить Дату рождения!");
        }
    }

    /**
     * проверяет строку на правильное количество параметров
     *
     * @param inputString проверяемая строка
     * @return true, если в строке введено правильное количество параметров
     * @throws InputException возникает исключение, если строка не соответствует требованиям
     */
    public static boolean ValidatorInputString(String inputString) throws InputException {
        boolean bool = true;
        if (inputString == null || inputString.isEmpty()) {
            throw new InputException("Вы не ввели данные!");
        }
        inpData = inputString.split(" ");
        if (inpData.length < countData) {
            throw new InputException("Данных меньше, чем должно быть!");
        }
        if (inpData.length > countData) {
            throw new InputException("Данных больше, чем должно быть!");
        }
        return bool;
    }

}
