
/**
 * @author Anastasiya Solodkaya.
 */
public class LocalClassVariablesAccessExample {
    public static void main(String[] args) {
        int var0 = 10;
        final int var1 = 15;
        int var2 = 15;
        var2 = 15;
        int var3 = 15;
        class Local {

            class T {

            }

            public void print(){
                // effectively final
                System.out.println(var0);
                // final
                System.out.println(var1);
                // not effectively final!
//                System.out.println(var2);
                // not effectively final!
//                System.out.println(var3);

                T t = new T();
            }
        }

        var3 = 16;
        Local l = new Local();
    }
}
