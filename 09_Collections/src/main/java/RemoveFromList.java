import java.util.ArrayList;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class RemoveFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        System.out.println("list.remove(1) = " + list.remove(1));
        System.out.println(list);
        System.out.println("list.remove(new Integer(3)) = " + list.remove(new Integer(3)));
        System.out.println("? should it remove item '5'?");
        System.out.println(list);
    }
}
