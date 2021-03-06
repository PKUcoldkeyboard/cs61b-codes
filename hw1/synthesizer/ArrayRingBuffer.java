package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    private class BufferIterator implements Iterator<T> {
        private int ptr;
        private int curSum;

        public BufferIterator() {
            ptr = first;
        }

        @Override
        public boolean hasNext() {
            return curSum < fillCount;
        }

        @Override
        public T next() {
            T item = rb[ptr];
            ptr = plus(ptr);
            curSum++;
            return item;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        last = plus(last);
        rb[last] = x;
        if (isEmpty()) {
            first = last;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T item = rb[first];
        if (fillCount != 1) {
            first = plus(first);
        }
        fillCount--;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }


    private int plus(int index) {
        return (index + 1) % capacity;
    }


    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }
}
