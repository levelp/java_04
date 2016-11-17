import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Anastasiya Solodkaya.
 */
public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("D");
        list.add("D");
        list.add("C");

        System.out.println("Оригинальный вид:");
        iterate(list);
        iterateAndAdd(list);
        System.out.println("После добавления элементов \"T\":");
        iterate(list);
        iterateAndRemove(list);
        System.out.println("После удаления элемента \"B\":");
        iterate(list);
        System.out.println("В обратном порядке:");
        iterateBackward(list);

//        iterateAndFail(list);
//        iterateAndFail2(list);
    }

    private static void iterateAndRemove(List<String> list) {
        ListIterator<String> iterator2 = list.listIterator();
        while(iterator2.hasNext()){
            String next = iterator2.next();
            // Удалить элемент B
            if(next.equals("B")){
                iterator2.remove();
            }
        }
    }

    private static void iterate(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("next = " + next);
        }
    }

    private static void iterateBackward(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()){
            String next = iterator.previous();
            System.out.printf("next (%s) = %s%n", iterator.previousIndex() + 1, next);
        }
    }

    private static void iterateAndAdd(List<String> list) {
        ListIterator<String> iterator2 = list.listIterator();
        while(iterator2.hasNext()){
            String next = iterator2.next();
            // После каждого элемента D добавить T
            if(next.equals("D")){
                iterator2.add("T");
            }
        }
    }

    private static void iterateAndFail(List<String> list) {
        Iterator<String> iterator = list.listIterator();
        list.add("123");
        while(iterator.hasNext()){
            String next = iterator.next();
            // Удалить элемент B
            System.out.println("next = " + next);
        }
    }

    private static void iterateAndFail2(List<String> list) {
        for (String s : list) {
            System.out.println(s);
            list.add("uuu");
        }
    }

}
