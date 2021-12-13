package synthesizer;

/**
 * @author cuterwrite
 * @created 2021/12/13-22:39
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    public int capacity() {
        return capacity;
    }

    public int fillCount() {
        return fillCount;
    }

    public boolean isEmpty() {
        return fillCount == 0;
    }

    public boolean isFull() {
        return fillCount == capacity;
    }

    public abstract T peek();

    public abstract T dequeue();

    public abstract void enqueue(T x);

}
