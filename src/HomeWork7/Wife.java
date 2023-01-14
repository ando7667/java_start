package HomeWork7;

public class Wife extends Person implements Female {

    public Wife (String name, Optional opt){
        this.firstName = name;
        this.optional = new Optional<>(opt.param1, opt.param2);
    }

}
