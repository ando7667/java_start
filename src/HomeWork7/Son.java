package HomeWork7;

public class Son extends Person implements Male, Colors {

    Colors.color hairColor = Colors.color.brown;
    Colors.color eyeColor = Colors.color.blue;

    Son(String name, Optional opt) {
        this.firstName = name;
        this.gender = Gender.male;
        this.optional = new Optional<>(opt.param1, opt.param2);

    }

}
