import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Тестирование обработки исключений
 */
public class JUnitCheckException {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testArray1() {
        MyArray myArray = new MyArray();
        myArray.get(-1);
    }

    @Test
    public void testArray2() {
        MyArray myArray = new MyArray();
        try {
            myArray.get(-1);
            fail("Должно быть исключение, т.к. индекс за пределами массива");
        } catch (IndexOutOfBoundsException ex) {
            assertEquals("Индекс за пределами массива", ex.getMessage());
        }
    }
}
