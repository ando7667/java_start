package HomeWork7;

public class Wife extends Person implements Female {
    public Wife(String name) {
        this.firstName = name;
        this.gender = Gender.female;
    }

}
