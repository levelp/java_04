import java.util.Random;

/// Утверждения
/// -----------
/// Книга: Программист-прагматик. Путь от подмастерья к мастеру
/// http://www.ozon.ru/context/detail/id/1657382/
/// "Мёртвые программы не лгут"
/// Подсказка 32: Пусть аварийное завершение работы программы произойдет как можно раньше
public class AssertDemo {

    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(10);
        System.out.println("a = " + a);
        /// Проверка утверждения
        /// assert Утверждение;
        /// assert Утверждение : Сообщение_об_ошибке;
        //-->
        assert a > 4 : "a = " + a;
        assert a > 1; // Вариант без сообщения об ошибке
        //<--
        /// Должно быть сообщение:
        /// Exception in thread "main" java.lang.AssertionError:
        /// a = 9
        /// Для включения нужен ключ VM: -ea (-enableAssertions)
    }
}
