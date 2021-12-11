import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author cuterwrite
 * @date 2021/12/11-17:18
 */
public class ArrayDequeTest extends TestCase {

    private Random random;

    @Before
    public void setUp() {
        random = new Random();
    }

    @Test
    public void testAddGet() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int[] testCases = new int[100];
        for (int i = 0; i < 100; i++) {
            int next = random.nextInt();
            testCases[i] = next;
            list.addLast(next);
        }
        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(testCases[i]), list.get(i));
        }
    }

    @Test
    public void testAddSize() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            list.addFirst(random.nextInt());
            assertEquals(i + 1, list.size());
        }
        for (int i = 100; i < 200; i++) {
            list.addLast(random.nextInt());
            assertEquals(i + 1, list.size());
        }
    }

    @Test
    public void testAddFirstRemoveFirstIsEmpty() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        assertEquals(true, list.isEmpty());
        list.addFirst(10);
        assertEquals(false, list.isEmpty());
        list.removeFirst();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testAddFirstRemoveLastIsEmpty() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        assertEquals(true, list.isEmpty());
        list.addFirst(10);
        assertEquals(false, list.isEmpty());
        list.removeLast();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testAddLastRemoveFirstIsEmpty() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        assertEquals(true, list.isEmpty());
        list.addLast(10);
        assertEquals(false, list.isEmpty());
        list.removeFirst();
        assertEquals(true, list.isEmpty());
    }

    @Test
    public void testAddLastRemoveLastIsEmpty() {
        ArrayDeque<Integer> list = new ArrayDeque<>();
        assertEquals(true, list.isEmpty());
        list.addLast(10);
        assertEquals(false, list.isEmpty());
        list.removeLast();
        assertEquals(true, list.isEmpty());
    }

}
