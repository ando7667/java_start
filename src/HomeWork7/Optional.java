package HomeWork7;

public class Optional<T, U> {

    T param1;
    U param2;

    Optional(T p1, U p2) {
        param1 = p1;
        param2 = p2;
    }

    public T getParam1() {
        return param1;
    }

    public U getParam2() {
        return param2;
    }
}
