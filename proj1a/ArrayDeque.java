import java.util.Arrays;

/**
 * @author cuterwrite
 * @date 2021/12/10-22:56
 */
public class ArrayDeque<T> {
    private T[] array;
    private int size;

    public ArrayDeque() {
        array = (T[]) new Object[8];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        // 首先检查是否需要扩容或减容，执行对应操作
        checkCapacity();
        for (int i = size; i >= 1; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }

    public void addLast(T item) {
        checkCapacity();
        array[size] = item;
        size++;
    }

    public T removeFirst() {
        checkCapacity();
        T item = get(0);
        if (item == null) {
            return null;
        }
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return item;
    }

    public T removeLast() {
        checkCapacity();
        T item = get(size - 1);
        if (item == null) {
            // 不用减size
            return null;
        }
        array[size - 1] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public void printDeque() {

    }

    private void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }

    private void checkCapacity() {
        if (array.length - 1 == size) {
            int newSize = size + (size >> 1);
            resize(newSize);
        } else if (array.length > 8 && array.length > 4 * size) {
            int newSize = Math.min(8, size / 2);
            resize(newSize);
        }
    }
}
