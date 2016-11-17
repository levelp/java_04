import org.junit.*;

/**
 * Аннотации JUnit
 */
public class BeforeAfterClass {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeAfterClass.beforeClass");
    }

    @BeforeClass
    public static void beforeClass2() {
        System.out.println("BeforeAfterClass.beforeClass2");
    }

    @BeforeClass
    public static void beforeClass3() {
        System.out.println("BeforeAfterClass.beforeClass3");
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("BeforeAfterClass.afterClass");
    }

    @AfterClass
    public static void afterClass2() {
        System.out.println("BeforeAfterClass.afterClass2");
    }

    @AfterClass
    public static void afterClass3() {
        System.out.println("BeforeAfterClass.afterClass3");
    }


    @Before
    public void before() {
        System.out.println("BeforeAfterClass.before");
    }

    @After
    public void after() {
        System.out.println("BeforeAfterClass.after");
    }

    //
    @Test
    public void test1() {
        System.out.println("BeforeAfterClass.test1");
    }

    @Test(expected = Exception.class)
    public void test2() throws Exception {
        System.out.println("BeforeAfterClass.test2");
        throw new Exception("Необходимое исключение");
    }


}
