import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Map
 */
public class MapTest extends Assert {

    static Map<Class, Class> types = new HashMap<>();

    static {
        types.put(Byte.TYPE, Byte.class);
        types.put(Short.TYPE, Short.class);
        types.put(Integer.TYPE, Integer.class);
        types.put(Long.TYPE, Long.class);
        types.put(Float.TYPE, Float.class);
        types.put(Double.TYPE, Double.class);
        types.put(Character.TYPE, Character.class);
        types.put(Boolean.TYPE, Boolean.class);
    }

    // Получаем класс-обёртку по примитивному типу
    @Test
    public void testGetClassByPrimitiveType() {
        assertEquals(Byte.class, types.get(Byte.TYPE));
        assertEquals(Short.class, types.get(Short.TYPE));
        assertEquals(Integer.class, types.get(Integer.TYPE));
        assertEquals(Long.class, types.get(Long.TYPE));
        assertEquals(Float.class, types.get(Float.TYPE));
        assertEquals(Double.class, types.get(Double.TYPE));
        assertEquals(Character.class, types.get(Character.TYPE));
        assertEquals(Boolean.class, types.get(Boolean.TYPE));
    }

    // Работа со словарём
    @Test
    public void testMapOperations() {
        Map<String, String> map = new HashMap<>();

        assertTrue("Список пуст", map.isEmpty());

        map.put("Hi", "Привет");
        assertEquals(1, map.size());

        map.put("Size", "Размер");

        assertEquals("Привет", map.get("Hi"));
    }
}
