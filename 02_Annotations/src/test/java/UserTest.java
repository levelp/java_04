import org.junit.Assert;
import org.junit.Test;
/// Подключить все методы: assertEquals можно с помощью
/// ``` java
/// import static org.junit.Assert.*;
/// ```

/// Или сделав класс с тестами наследником Assert
//-->
public class UserTest extends Assert {
    @Test
    public void testUser() {
        User user = new User();
        user.name = "Иван Иванович Иванов";

        // Метаинформация о классе User
        Class userClass = user.getClass();
        TableName tableName = (TableName) userClass.getAnnotation(TableName.class);
        // Если нет такой аннотации
        assertNotNull(tableName);
        assertEquals("main_users", tableName.value());
    }
}
//<--
