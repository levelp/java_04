
import java.util.Comparator;

/**
 * @author Anastasiya Solodkaya.
 */
public class LocalClassExample {
    private int i;

    public static void main(String[] args) {
        // Не может быть интерфейсом
        class Local implements Comparator<String> {
            private int y;

            public Local(int y) {
                this.y = y;
            }

            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }

            public void print(){
                // В методе статическом не имеет доступа к членам экземпляре
//                System.out.println(LocalClassExample.this.i);
                System.out.println(this.y);
            }
        }

        Local l = new Local(1);
    }

    // В методе экземпляра имеет доступ к членам экземпляре
    public void test() {
        // Не может быть интерфейсом
        class Local implements Comparator<String> {
            private int y;

            public Local(int y) {
                this.y = y;
            }

            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }

            public void print(){
                System.out.println(LocalClassExample.this.i);
                System.out.println(this.y);
            }
        }


    }
}
