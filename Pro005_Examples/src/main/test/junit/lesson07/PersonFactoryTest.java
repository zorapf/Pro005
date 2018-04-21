package junit.lesson07;

import org.junit.Assert;
import org.junit.Test;

public class PersonFactoryTest {

    @Test
    public void newPersonCorrect() {
        String paramName = "Ivan";
        String paramSurname = "Ivanov";
        Integer paramAge = 25;

        Person person = PersonFactory
                .newPerson(paramName, paramSurname, paramAge);

        Assert.assertEquals(paramName, person.getName());
        Assert.assertEquals(paramSurname, person.getSurname());
        Assert.assertEquals(paramAge, person.getAge());
    }
}
