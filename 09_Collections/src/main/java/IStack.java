/**
 * Интерфейс необходимо реализовать на основе списка (не List, а структуры "односвязный список"). Как пример -
 * LinkedList написан на основе структуры "двусвязный список".
 * Интерфейс представляет собой классический стек first-in-last-out.
 */
public interface IStack<E> {
    /**
     * Добавляет элемент на стек.
     * @param element элемент для добавления
     */
    void push(E element);

    /**
     * Возвращает следующий элемент и удаляет его со стека.
     * Подумать, что вы будете делать, если стек пустой. Можно добавить в интефейс throws.
     * @return следующий элемент, если есть
     */
    E pop();
    /**
     * Возвращает следующий элемент, но удаляет его со стека.
     * Подумать, что вы будете делать, если стек пустой. Можно добавить в интефейс throws.
     * @return следующий элемент, если есть
     */
    E peek();

    /**
     * Возвращает текущий размер стека
     * @return размер стека
     */
    int size();

    /**
     * Показывает, пуст ли стек
     * @return true, если пуст. Иначе - false
     */
    boolean isEmpty();

}