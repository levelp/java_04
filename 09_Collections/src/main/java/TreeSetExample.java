import java.util.TreeSet;

/**
 * @author Anastasiya Solodkaya.
 */
public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(10);
        treeSet.add(9);
        treeSet.add(6);

        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println("treeSet.isEmpty() = " + treeSet.isEmpty());
        System.out.println("treeSet.ceiling(4) = " + treeSet.ceiling(4));
        System.out.println("treeSet.floor(7) = " + treeSet.floor(7));

        treeSet.remove(6);

        System.out.println("treeSet.ceiling(4) = " + treeSet.ceiling(4));

        treeSet.clear();
        System.out.println("treeSet.isEmpty() = " + treeSet.isEmpty());
    }
}
