import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

///
/// Тесты на JUnit3
///
/// Тестовый класс должен быть наследником TestCase (junit.framework.TestCase)
//-->
public class JUnit3Demo extends TestCase {

    private final Map<String, byte[]> toHexStringData = new HashMap<String, byte[]>();

    protected static void setUpClass() {
        System.out.println("JUnit3Demo.setUpClass");
    }

    protected static void tearDownClass() {
        System.out.println("JUnit3Demo.tearDownClass");
    }

    public void testIsEmpty() {
        boolean actual = StringUtils.isEmpty(null);
        assertTrue(actual);

        actual = StringUtils.isEmpty("");
        assertTrue(actual);

        actual = StringUtils.isEmpty(" ");
        assertFalse(actual);

        actual = StringUtils.isEmpty("some string");
        assertFalse(actual);
    }

    // Аналог @Before из JUnit4
    protected void setUp() throws Exception {
        toHexStringData.put("", new byte[0]);
        toHexStringData.put("01020d112d7f", new byte[]{1, 2, 13, 17, 45, 127});
        toHexStringData.put("00fff21180", new byte[]{0, -1, -14, 17, -128});
        //...
    }

    // Аналог @After из JUnit4
    protected void tearDown() throws Exception {
        toHexStringData.clear();
    }

    public void testToHexString() {
        for (Object o : toHexStringData.keySet()) {
            final String expected = (String) o;
            final byte[] testData = toHexStringData.get(expected);
            final String actual = StringUtils.toHexString(testData);
            assertEquals(expected, actual);
        }
    }
}
//<--
