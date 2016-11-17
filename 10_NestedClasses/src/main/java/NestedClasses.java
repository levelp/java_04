
import java.util.Comparator;

/**
 * @author Anastasiya Solodkaya.
 */
public class NestedClasses {
    public static void main(String[] args) {
        NestedClasses classes = new NestedClasses();
        Inner inner = classes.new Inner();


        // local
        class Local {
            int field;

            public Local(int field) {
                this.field = field;
            }

            public int getField() {
                return field;
            }
        }

        // anonymous
        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };
    }

    // nested
    public static class Nested {

    }

    // inner
    public class Inner {

    }
}
