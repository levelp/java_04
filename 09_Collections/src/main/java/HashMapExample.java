import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Anastasiya Solodkaya.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("C", 1);
        map.put("V", 2);
        map.put("B", 9);

        System.out.println("map.get(\"C\") = " + map.get("C"));

        System.out.println("map.containsKey(\"V\") = " + map.containsKey("V"));
        System.out.println("map.containsValue(9) = " + map.containsValue(9));
        System.out.println("map.containsValue(11) = " + map.containsValue(11));

        Set<String> keys = map.keySet();
        System.out.println("keys = " + keys);
        Collection<Integer> values = map.values();
        System.out.println("values = " + values);

        map.remove("C");
        keys = map.keySet();
        System.out.println("keys = " + keys);

        System.out.println("map.isEmpty() = " + map.isEmpty());
        map.clear();
        System.out.println("map.isEmpty() = " + map.isEmpty());

    }
}
