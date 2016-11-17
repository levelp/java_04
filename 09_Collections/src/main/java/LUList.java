/**
 * @author Anastasiya Solodkaya.
 */
public class LUList<E> {
    private class Entry {
        private E element;
        private Entry next;

        public Entry(E element) {
            this(element, null);
        }

        public Entry(E element, Entry next) {
            this.element = element;
            this.next = next;
        }
    }

    Entry head = null;

    public LUList() {
    }

    public void add(E element) {
        head = new Entry(element, head);
    }

    public void reverse(){

    }

    @Override
    public String toString() {
        Entry pointer = head;
        StringBuilder builder = new StringBuilder();
        while(pointer != null){
            builder.append("{ " + pointer.element + " }");
            builder.append(" -> ");
            pointer = pointer.next;
        }
        builder.append(" null ");
        return builder.toString();
    }

    public static void main(String[] args) {
        LUList<Integer> list = new LUList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
