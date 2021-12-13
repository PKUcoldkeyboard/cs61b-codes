package synthesizer;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        assertEquals(Integer.valueOf(1), arb.peek());
        arb.enqueue(2);
        arb.enqueue(3);
        assertEquals(Integer.valueOf(1), arb.dequeue());
        assertEquals(Integer.valueOf(2), arb.dequeue());
        assertEquals(Integer.valueOf(3), arb.dequeue());
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
