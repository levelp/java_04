
/**
 * @author Anastasiya Solodkaya.
 */
public class On {
    public static void o_1() {
        // single operation
        int x = 3 % 2;

        // array access
        int[] ints = {0, 4, 2, 1};
        int i = ints[1];


        // constant operation
        int u = ints[1] % ints[2];
    }


    public static void o_n() {
        // array iteration
        int N = 10;
        int[] ints = new int[N];

        int sum = 0;
        // O(N)
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
    }

    public static void o_n2() {
        // array iteration
        int N = 10;
        int[] ints0 = new int[N];
        int[] ints1 = new int[N];

        int sumMult = 0;
        // O(N)
        for (int i = 0; i < ints0.length; i++) {
            for (int j = 0; j < ints1.length; j++) {
                sumMult += ints0[i] * ints1[j];
            }
        }
    }

    public static void o_n3() {
        // array iteration
        int N = 10;
        int[] ints0 = new int[N];
        int[] ints1 = new int[N];
        int[] ints2 = new int[N];

        int sumMult = 0;
        // O(N)
        for (int i = 0; i < ints0.length; i++) {
            for (int j = 0; j < ints1.length; j++) {
                for (int k = 0; k < ints2.length; k++) {
                    sumMult += ints0[i] * ints1[j] * ints2[k];
                }
            }
        }
    }

}
