<!-- doc.py -->
Утверждения
-----------
Книга: Программист-прагматик. Путь от подмастерья к мастеру
http://www.ozon.ru/context/detail/id/1657382/
"Мёртвые программы не лгут"
Подсказка 32: Пусть аварийное завершение работы программы произойдет как можно раньше
Проверка утверждения
assert Утверждение;
assert Утверждение : Сообщение_об_ошибке;
``` java
        assert a > 10 : "a = " + a;
        assert a > 1; // Вариант без сообщения об ошибке
```

Должно быть сообщение:
Exception in thread "main" java.lang.AssertionError:
a = 9
Для включения нужен ключ VM: -ea (-enableAssertions)
[src/main/java/AssertDemo.java](src/main/java/AssertDemo.java)

