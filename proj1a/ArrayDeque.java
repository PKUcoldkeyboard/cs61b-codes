import java.util.Arrays;

/**
 * @author cuterwrite
 * @date 2021/12/10-22:56
 */
public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int head;
    private int end;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        head = end = 4;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        if (array.length - 1 == size) {
            // 进行扩容
            int newSize = size + (size >> 1);
            resize(newSize);
        }
        array[--head] = item;
        size++;
    }

    public void addLast(T item) {
        if (array.length - 1 == size) {
            // 进行扩容
            int newSize = size + (size >> 1);
            resize(newSize);
        }
        array[++end] = item;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = array[head];
        array[head++] = null;
        checkUsage();
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = array[end];
        array[end--] = null;
        checkUsage();
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
        for (int i = head; i <= end; i++) {
            System.out.print(array[i].toString() + " ");
        }
        System.out.println();
    }

    private void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }

    private void checkUsage() {
        if (array.length > 4 * size) {
            resize(size / 2);
        }
    }
}
