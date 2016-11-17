package list;

import java.util.Iterator;

/**
 * Своя реализация списка
 * T - тип значений в списке
 */
public class MyList<T> implements Iterable<T> {
    /**
     * head - начало списка
     * tail - конец списка
     */
    Element<T> head = null, tail = null;
    int count = 0;

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public int size() {
        return count;
    }

    public void add(T value) {
        Element<T> newElement = new Element<>(value);
        count++;
        // Если список пуст
        if (head == null) {
            assert tail == null : "Недопустимое сообщение";
            head = newElement;
            tail = newElement;
            return;
        }
        // Если список не пуст
        // Добавляем элемент в конец списка
        tail.next = newElement;
        // Теперь новый элемент - последний
        tail = newElement;
    }

    public T get(int index) {
        checkIndex(index);
        Element<T> cur = head;
        for (int i = 0; i < index; ++i)
            cur = cur.next;
        return cur.value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException(
                    "Индекс " + index + " за пределами списка." +
                            "Корректные индексы: 0.." + (count - 1)
            );
    }

    public void removeByIndex(int index) {
        checkIndex(index);
        count--;
        if (index == 0) {
            head = head.next;
            if (head == null)
                tail = null;
            return;
        }
        Element<T> prev = head;
        for (int i = 0; i < index - 1; ++i)
            prev = prev.next;
        // Если удаляем последний элемент,
        // то двигаем хвост назад
        if (prev.next == tail) {
            tail = prev;
        }
        prev.next = prev.next.next;
    }

    /**
     * Элемент списка
     *
     * @param <T> тип значений в списке
     */
    public static class Element<T> {
        T value;
        Element<T> next = null;

        public Element(T value) {
            this.value = value;
        }
    }

    public class MyIterator implements Iterator<T> {
        private Element<T> cur;

        public MyIterator() {
            this.cur = head;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            if (cur == null)
                throw new IndexOutOfBoundsException("Список кончился");
            T value = cur.value;
            cur = cur.next;
            return value;
        }
    }
}
