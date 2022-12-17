package HomeWork7;

public class Male extends Person {
    public Male(String first) {
        this.firstName = first;
        this.gender = Gender.male;
    }

    public String apper() {
        return "Он";
    }
}
