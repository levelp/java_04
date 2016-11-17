import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Anastasiya Solodkaya.
 */
public class IteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("D");
        list.add("C");

        System.out.println("Оригинальный вид:");
        iterate(list);
        iterateAndRemove(list);
        System.out.println("После удаления элемента \"B\":");
        iterate(list);

        iterateAndFail(list);
    }

    private static void iterateAndRemove(List<String> list) {
        Iterator<String> iterator2 = list.iterator();
        while(iterator2.hasNext()){
            String next = iterator2.next();
            // Удалить элемент B
            if(next.equals("B")){
                iterator2.remove();
            }
        }
    }

    private static void iterate(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    private static void iterateAndFail(List<String> list) {
        Iterator<String> iterator = list.iterator();
        list.add("123");
        while(iterator.hasNext()){
            String next = iterator.next();
            // Удалить элемент B
            System.out.println("next = " + next);
        }
    }

}
