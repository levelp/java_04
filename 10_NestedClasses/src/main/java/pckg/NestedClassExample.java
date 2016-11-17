package pckg;

/**
 * @author Anastasiya Solodkaya.
 */
public class NestedClassExample {
    private int t1;
    private static int t2;

    public static class Nested {
        public Nested() {
            // no access to instance member
//            System.out.println(t1);
            // have access to static private
            System.out.println(t2);
        }
    }
}

