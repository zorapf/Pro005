package junit.lesson07;

import org.junit.Test;

import static org.junit.Assert.*;

/* Основное назначение модульного
   тестирования - проверка отдельных
   компонентов программы на корректную
   работу*/

public class JUnitEx01Test {

    /*Проверка методов на позитивный и
    * негативный результат*/
    @Test
    public void sumPositive() {
        /*assertEquals() - сравнивает ожидаемый результат
        *                  с фактическим который был
        *                  получен в процессе работы метода
        *
        * Тест будет пройден если при всех вызовах ожидаемый
        * результат будет равен фактическому */
        assertEquals(4, JUnitEx01.sum(2, 2));
        assertEquals(4, JUnitEx01.sum(1, 3));
        assertEquals(4, JUnitEx01.sum(4, 0));
    }

    @Test
    public void sumNegative() {
        /* assertNotEquals() - сравнивает ожидаемый результат
         *                     с фактическим
         * Тест будет пройден успешно если ожидаемый результат
         * не равен фактическому */
        assertNotEquals(6, JUnitEx01.sum(3, 4));
        assertNotEquals(7, JUnitEx01.sum(3, 1));
        assertNotEquals(5, JUnitEx01.sum(8, 7));
    }
}
