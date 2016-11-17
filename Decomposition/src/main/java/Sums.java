import static java.lang.Math.min;
import static java.lang.System.out;

/**
 * Разложение целого числа на слагаемые всеми возможными
 * способами
 */
public class Sums {
    private int N;
    // Слагаемые
    private int[] A;

    public Sums(int N) {
        this.N = N;
    }

    public static void main(String[] args) {
        for (int N = 1; N < 10; N++) {
            Sums sums = new Sums(N);
            sums.printAll();
        }
    }

    private void printAll() {
        // Оставшуюся сумму,
        // верхний предел для слагаемого
        // индекс следуюшего слагаемого
        A = new int[N];
        f(N, 0);
    }

    /**
     * @param S Оставшаяся сумма
     * @param i индекс текущего слагаемого
     */
    private void f(int S, int i) {
        // Если всё разложили, то печатаем ответ
        if (S == 0) {
            out.print(N + " = " + A[0]);
            for (int j = 1; j < i; j++)
                out.print(" + " + A[j]);
            out.println();
            return;
        }
        // Генерируем очередное слагаемое
        // Очередное слагаемое не может быть
        // оставшейся суммы и не может быть
        // больше предыдущего

        // Верхний предел для слагаемого
        // (предыдущее слагаемое)
        int max = N;
        if (i > 0) max = A[i - 1];
        for (int x = min(S, max); x >= 1; x--) {
            A[i] = x;
            // Если мы поставили очередное слагаемое x
            // То новая сумма: S - x
            // И двигаемся вперед по массиву слагаемых:
            // i + 1
            f(S - x, i + 1);
        }
    }
}
