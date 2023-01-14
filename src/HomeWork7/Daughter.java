package HomeWork7;

public class Daughter extends Person implements Female {

    public Daughter(String name, Optional opt) {
        this.gender = Gender.female;
        this.firstName = name;
        this.optional = new Optional<>(opt.param1, opt.param2);
    }

}
