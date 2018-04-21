package junit.lesson07;

public class PersonFactory {

    public static Person newPerson(
            String name, String surname, Integer age) {
        return new Person(name, surname, age);
    }
}
