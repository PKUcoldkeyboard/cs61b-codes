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
        if (array.length == size) {
            int newSize = size + (size >> 1);
            resize(newSize);
        }
        for (int i = size; i >= 1; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }

    public void addLast(T item) {
        if (array.length == size) {
            // 进行扩容
            int newSize = size + (size >> 1);
            resize(newSize);
        }
        array[size++] = item;
    }

    public T removeFirst() {
        T item = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return item;
    }

    public T removeLast() {
        T item = array[size - 1];
        array[--size] = null;
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public void printDeque() {
        for (T item : array) {
            if (item != null) {
                System.out.print(item.toString() + " ");
            }
        }
        System.out.println();
    }

    private void resize(int newSize) {
        array = Arrays.copyOf(array, newSize);
    }
}
