import java.util.ArrayDeque;

/**
 * @author Anastasiya Solodkaya.
 */
public class ArrayDequeExample {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.push("A");
        deque.push("B");
        deque.push("F");
        deque.push("J");

        System.out.println("deque.peek() = " + deque.peek());
        System.out.println("deque.poll() = " + deque.poll());
        System.out.println("deque.peek() = " + deque.peek());
        System.out.println("deque.pollLast() = " + deque.pollLast());

        System.out.println("deque.size() = " + deque.size());
        System.out.println("deque.isEmpty() = " + deque.isEmpty());
        deque.clear();
        System.out.println("deque.isEmpty() = " + deque.isEmpty());

    }
}
