package junit.lesson07;

public class Person {

    private String name;

    private String surname;

    private Integer age;

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof Person) {
        if (getClass() == obj.getClass()) {
            Person person = (Person) obj;
            if (person.name.equals(this.name)
                    && person.surname.equals(this.surname)
                        && person.age == this.age) {
                return true;
            }
        }
        return false;
    }


}
