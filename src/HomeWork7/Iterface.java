package HomeWork7;

import java.util.ArrayList;

public class Iterface {
    public static String people(ArrayList<Person> Data) {
        StringBuilder res = new StringBuilder();
        for (Person person : Data) {
            res.append(person.getFullName()).append('\t');
        }
        return res.toString();
    }



}
