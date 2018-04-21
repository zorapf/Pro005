package junit.lesson07;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonClassTest {

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;

    /** @Before - метод который отмечен данной анотацией
     *            будет выполнен перед каждым методом с
     *            анотацией @Test
     *  @After  - метод будет вызван после выполнения
     *            метода отмеченого анотацией @Test*/
    @Before
    public void init() {
        person1 = PersonFactory
                .newPerson("Ivan", "Ivanov", 25);
        person2 = PersonFactory
                .newPerson("Ivan", "Ivanov", 25);
        person3 = PersonFactory
                .newPerson("Ivan", "Ivanov", 42);
        person4 = PersonFactory
                .newPerson("Ivan", "Ivanov", 25);
    }

    @Test
    public void personEqualsCorrect() {
        /*Проверка boolean-методов на корректный результат*/
        Assert.assertTrue("Классы Person равны", person1.equals(person2));
        Assert.assertTrue("Классы Person равны", person2.equals(person4));
        Assert.assertTrue("Классы Person равны", person4.equals(person1));
        Assert.assertTrue("Классы Person равны", person4.equals(person3));
    }

    @Test
    public void personEqualsIncorrect() {
        Assert.assertFalse("Классы Person не равны", person1.equals(person3));
        Assert.assertFalse("Классы Person не равны", person2.equals(person3));
        Assert.assertFalse("Классы Person не равны", person4.equals(person3));
    }

    @After
    public void afterTestCase() {
        person1 = person2 = person3 = person4 = null;
    }
}
