import java.util.ArrayList;

/**
 * @author Anastasiya Solodkaya.
 */
public class ListExample {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add(0, "B");

        // B
        // A
        System.out.println("----- 1");
        for (String s : list) {
            System.out.println(s);
        }

        list.add("C");
        list.add("D");

        // B
        // A
        // C
        // D
        System.out.println("----- 2");
        for (String s : list) {
            System.out.println(s);
        }

        list.set(1, "F");

        // B
        // F
        // C
        // D
        System.out.println("----- 3");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("Is empty? " + list.isEmpty());
        System.out.println("Size: " + list.size());

        list.clear();

        System.out.println("Is empty? " + list.isEmpty());
    }
}
