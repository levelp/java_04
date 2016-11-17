import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Дерамида
 */
public class TreapTest {
    @Test
    public void testTreap() {
        Treap treap = new Treap(2);
        assertTrue(treap.find(2));
        assertFalse(treap.find(3));
        treap = treap.Add(3);
        assertTrue(treap.find(2));
        assertTrue(treap.find(3));
        assertFalse(treap.find(4));
        treap = treap.Add(1);
        assertFalse(treap.find(0));
        assertTrue(treap.find(1));
        assertTrue(treap.find(2));
        assertTrue(treap.find(3));
        assertFalse(treap.find(4));

        treap = treap.Remove(2);
        assertFalse(treap.find(0));
        assertTrue(treap.find(1));
        assertFalse(treap.find(2));
        assertTrue(treap.find(3));
        assertFalse(treap.find(4));
    }
}
