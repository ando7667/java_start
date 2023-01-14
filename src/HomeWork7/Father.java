package HomeWork7;

public class Father extends Person implements Male {

    Father(String name, Optional<String, String> opt){
        this.firstName = name;
        this.optional = new Optional<>(opt.param1, opt.param2);
    }

}
