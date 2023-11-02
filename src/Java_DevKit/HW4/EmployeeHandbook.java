package Java_DevKit.HW4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeHandbook {

    private final ArrayList<Person> persons;

    public EmployeeHandbook(){
        this.persons = new ArrayList<Person>();
    }

    void add(String phone, String name, int standing) {
        int lastId = 0;
        if (!this.persons.isEmpty()) {
            lastId = this.persons.stream().mapToInt(Person::getEmployeeNumber).max().getAsInt();
        }
        this.persons.add(new Person(lastId + 1, phone, name, standing));
    }


    Person findByStanding(int standing) {
        var fn = this.persons.stream().filter(p -> p.getStanding() == standing).findAny();
        return fn.orElse(null);
    }

    void printFindStandingAll(int standing) {
        boolean prs = false;
        for (Person person: this.persons) {
            if (person.getStanding() == standing) {
                System.out.println(person);
                prs = true;
            }
        }
        if (!prs) {
            System.out.println("С таким стажем сотрудника нет!\n");
        }
    }

    List<String> findPhonesByName(String name) {
        return this.persons.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(Person::getPhone).toList();
    }

    Person findPersonByEmployee(int number){
        var fn = this.persons.stream().filter(p -> p.employeeNumber == number).findAny();
        return fn.orElse(null);
    }

    <R> List<R> findSomething(Predicate<Person> filter, Function<Person, R> mapper) {
        return this.persons.stream().filter(filter).map(mapper).toList();
    }

    public void forEach() {
        if (!this.persons.isEmpty()) {
            this.persons.forEach(System.out::println);
        }
    }
}
