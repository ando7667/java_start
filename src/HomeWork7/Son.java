package HomeWork7;

public class Son extends Person implements Male, Colors {

    Colors.color hairColor = Colors.color.brown;
    Colors.color eyeColor = Colors.color.blue;

    Son(String name) {
        this.firstName = name;
        this.gender = Gender.male;
    }

}
