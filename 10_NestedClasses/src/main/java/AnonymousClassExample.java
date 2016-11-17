
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Anastasiya Solodkaya.
 */
public class AnonymousClassExample {
    public static void main(String[] args) {
        String[] arr = new String[]{"a", "c", "b"};
        test(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

//        test(arr, new Comparator<String>() {
//
//            private int i;
//
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(o1.length() - i, o2.length());
//            }
//        });

        // lambda
        test(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
    }

    public static void test(String[] arr, Comparator<String> comparator){
        Arrays.sort(arr, comparator);
    }
}
