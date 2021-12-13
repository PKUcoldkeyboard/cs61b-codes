package synthesizer;

/**
 * @author cuterwrite
 * @date 2021/12/13-22:25
 */
public interface BoundedQueue<T> extends Iterable<T> {
    // return size of the buffer
    int capacity();

    // return number of items currently in the buffer
    int fillCount();

    // add item x to the end
    void enqueue(T x);

    // delete and return item from the front
    T dequeue();

    // return item from the front
    T peek();

    default boolean isEmpty() {
        return fillCount() == 0;
    }

    default boolean isFull() {
        return capacity() == fillCount();
    }
}
