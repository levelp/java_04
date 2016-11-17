import java.util.Random;

/**
 * Декартово дерево поиска (Tree + Heap = Treap)
 * Дерамида = дерево + пирамида
 * Декартово дерево - структура данных, объединяющая в себе бинарное дерево поиска и бинарную кучу
 * (отсюда и второе её название: treap (tree+heap) и дерамида (дерево+пирамида).
 * <p>
 * <T extends Comparable<T>> implements SearchTree<T>
 */
public class Treap {
    static private Random rand = new Random();
    public int x;
    public int y;
    public Treap Left;
    public Treap Right;

    public Treap(int x) {
        this(x, rand.nextInt());
    }

    private Treap(int x, int y) {
        this.x = x;
        this.y = y;
        this.Left = null;
        this.Right = null;
    }

    private Treap(int x, int y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.Left = left;
        this.Right = right;
    }

    /**
     * Слияние
     *
     * @param L левое поддерево
     * @param R правое поддерево
     * @return Объединённое дерево
     */
    public static Treap Merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;

        if (L.y > R.y) {
            return new Treap(L.x, L.y, L.Left, Merge(L.Right, R));
        } else {
            return new Treap(R.x, R.y, Merge(L, R.Left), R.Right);
        }
    }

    public Treap[] Split(int x) {
        Treap newTree = null;
        Treap L, R;
        if (this.x < x) {
            if (Right == null)
                R = null;
            else {
                Treap[] gg = Right.Split(x);
                newTree = gg[0];
                R = gg[1];
            }
            L = new Treap(this.x, y, Left, newTree);
        } else {
            if (Left == null)
                L = null;
            else {
                Treap[] gg = Left.Split(x);
                L = gg[0];
                newTree = gg[1];

            }
            R = new Treap(this.x, y, newTree, Right);
        }
        return new Treap[]{L, R};
    }

    /**
     * Поиск значения в дереве поиска
     *
     * @param value Значение
     * @return найдено ли значение?
     */
    public boolean find(int value) {
        if (x == value)
            return true;
        if (x > value)
            if (Left != null)
                return Left.find(value);
        if (x < value)
            if (Right != null)
                return Right.find(value);
        return false;
    }

    // здесь будут операции...

    public int deep() {
        return 0;
    }

    public Treap Add(int x) {
        Treap[] t = Split(x);
        Treap l = t[0];
        Treap r = t[1];
        Treap m = new Treap(x, rand.nextInt());
        return Merge(Merge(l, m), r);
    }

    public Treap Remove(int x) {
        if (this.x == x)
            return Merge(Left, Right);
        if (this.x > x)
            if (Left != null)
                Left = Left.Remove(x);
        if (this.x < x)
            if (Right != null)
                Right = Right.Remove(x);
        return this;
    }
}
