package HomeWork7;

public class Female extends Person {
    public Female(String first) {
        this.firstName = first;
        this.gender = Gender.female;
    }

    public String apper() {
        return "Она";
    }
}
