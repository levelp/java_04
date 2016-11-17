package list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестирование нашего списка
 */
public class MyListTest {

    /**
     * Простые операции добавления/удаления
     */
    @Test
    public void testIntegerList() {
        MyList<Integer> list = new MyList<>();
        assertEquals("Пока список пустой", 0, list.size());
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "] = " + list.get(i));
        }
        list.add(4);
        list.removeByIndex(0);
        assertEquals(1, list.size());
        assertEquals(4, list.get(0).intValue());
        list.removeByIndex(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testStringList() {
        MyList<String> list = new MyList<>();
        assertEquals("Пока список пустой", 0, list.size());
        list.add("Hello");
        list.add("world");
        assertEquals("Hello", list.get(0));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list[" + i + "] = " + list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }

        MyList.Element<Integer> element
                = new MyList.Element<>(2);
    }

}
