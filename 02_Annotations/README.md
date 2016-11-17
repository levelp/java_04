<!-- doc.py -->

Аннотация для столбца (поля) в базе данных
``` java
@interface Column {
    String value();

    // Максимальное количество символов
    // По-умолчанию: 0
    int maxLen() default 0;

    // Свойства аннотаций могут быть
    // любых примитивных типов + String + enum
    boolean isPassword() default false;
}
```

[src/main/java/Column.java](src/main/java/Column.java)

Является ли поле первичным ключом?
``` java
@Retention(RetentionPolicy.RUNTIME)
@interface PrimaryKey {
}
```

[src/main/java/PrimaryKey.java](src/main/java/PrimaryKey.java)

Объявление аннотации
--------------------
@Retention - служебная аннотация, которая
задаёт область видимости аннотаций
Значение "без имени" называется value()
[src/main/java/TableName.java](src/main/java/TableName.java)

Использование своих аннотаций
``` java
// users
@TableName("main_users")
class User {

    @PrimaryKey
    @Column("id")
    public int id;
    @Column(value = "password", isPassword = true)
    public String password;
    @Column(value = "NAME_STR", maxLen = 20)
    String name;

    /**
     * Альтернативный способ получения имя таблицы
     *
     * @return имя таблицы
     */
    String tableName() {
        return "main_users";
    }
}
```

[src/main/java/User.java](src/main/java/User.java)

Подключить все методы: assertEquals можно с помощью
``` java
import static org.junit.Assert.*;
```
Или сделав класс с тестами наследником Assert
``` java
public class UserTest extends Assert {
    @Test
    public void testUser() {
        User user = new User();
        user.name = "Иван Иванович Иванов";

        Class userClass = user.getClass();
        TableName tableName = (TableName) userClass.getAnnotation(TableName.class);
        assertNotNull(tableName);
        assertEquals("main_users", tableName.value());
    }
}
```

[src/test/java/UserTest.java](src/test/java/UserTest.java)

