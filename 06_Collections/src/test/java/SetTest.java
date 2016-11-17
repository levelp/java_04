import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/// Set - множество элементов
/// -------------------------
public class SetTest {

    static <T> Set<T> arrayToList(final T[] array) {
        final Set<T> l = new TreeSet<T>();
        Collections.addAll(l, array);
        return l;
    }

    public static void main(String[] args) {
        Set<String> strings = new HashSet<String>();
        strings.add("Hi");
        strings.add("Test");
        strings.add("Hi");
        for (String s : strings)
            System.out.println(s);
    }

    @SafeVarargs
    @SuppressWarnings("varargs")
    private static <T> Set<T> asSet(T... a) {
        return new TreeSet<T>(Arrays.asList(a));
    }

    /// Основные операции на множествах
    @Test
    @Ignore
    public void testHashSet() {
        Set<Integer> s = new HashSet<>(); // new TreeSet<Integer>();
        /// add(value) добавить в множество
        /// isEmpty() - пусто ли множество?
        /// size() - количество элементов в списке
        //-->
        assertTrue("Множество пусто", s.isEmpty());
        s.add(7);
        assertFalse("Теперь уже не пусто", s.isEmpty());
        s.add(7);
        assertEquals("В множестве 1 элемент т.к. значения совпадают", 1, s.size());
        s.add(10);
        assertEquals("В множестве 2 элемента", 2, s.size());
        //<--
        /// get(index) - получить элемент с заданным индексом
        assertTrue(s.contains(7));
        assertTrue(s.contains(10));

        /// Добавляем сразу массив элементов
        s.addAll(Arrays.asList(2, 5, 6));
        assertArrayEquals(new Integer[]{2, 5, 6, 7, 10}, setToArray(s));

        s.addAll(Arrays.asList(88, 99));
        assertTrue(s.contains(88));
        assertTrue(s.contains(99));
        assertEquals(asSet(2, 5, 6, 7, 10, 88, 99), s);

        /// remove(Object o) - удаление элемента по значению
        assertTrue(s.remove(99)); // А в множестве можно так писать!
        assertEquals(asSet(2, 5, 6, 7, 10, 88), s);

        assertFalse("Такого элемента нет", s.remove(1)); // Удалить элемент со значением 1
        assertEquals(asSet(2, 5, 6, 7, 10, 88), s);

        /// contains(Object o) - проверяет наличие элемента в множестве
        assertTrue(s.contains(7));
        assertTrue(s.contains(88));
        assertFalse(s.contains(89));

        /// Проверка, содержит ли одно множество другое множество
        assertTrue("Содержатся все эти элементы", s.containsAll(asSet(7, 10, 2)));
    }

    @Test
    public void iterators() {
        Set<Integer> list = new TreeSet<Integer>(Arrays.asList(2, 3, 5, 8, 13));

        // Получаем итератор
        Iterator<Integer> i = list.iterator();

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(2, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(3, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(5, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(8, i.next().intValue());

        assertTrue("Следующий элемент есть", i.hasNext());
        assertEquals(13, i.next().intValue());

        // Удаляем элемент
        // i.remove(); // java.lang.UnsupportedOperationException

        assertFalse("Элементы кончились", i.hasNext());
    }

    private Integer[] setToArray(Set<Integer> list) {
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);
        return array;
    }
}
