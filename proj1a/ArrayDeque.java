/**
 * 基于环形动态数组的ArrayDeque
 *
 * @author cuterwrite
 * @date 2021/12/10-22:56
 */
public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int head;
    private int tail;

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
        if (size == array.length) {
            resize(2 * size);
        }
        // 左端加入元素，需要减head
        head = minus(head);
        array[head] = item;
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(2 * size);
        }
        tail = plus(tail);
        array[tail] = item;
        if (isEmpty()) {
            head = tail;
        }
        size++;
    }

    public T removeFirst() {
        T item;
        if (isEmpty()) {
            item = null;
        } else if (size == 1) {
            item = array[head];
            size--;
        } else {
            item = array[head];
            head = plus(head);
            size--;
            if (size * 4 == array.length) {
                resize(size * 2);
            }
        }
        return item;
    }

    public T removeLast() {
        T item;
        if (isEmpty()) {
            item = null;
        } else if (size == 1) {
            item = array[tail];
            size--;
        } else {
            item = array[tail];
            tail = minus(tail);
            size--;
            if (size * 4 < array.length) {
                resize(size * 2);
            }
        }
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int j = head;
        for (int i = 0; i < index; i++) {
            j = plus(j);
        }
        return array[j];
    }

    public void printDeque() {
        int j = head;
        for (int i = 0; i < size; i++) {
            System.out.print(array[j] + " ");
            j = plus(j);
        }
        System.out.println();
    }

    private void resize(int newSize) {
        T[] temp = (T[]) new Object[newSize];
        int j = head;
        for (int i = 0; i < size; i++) {
            temp[i] = array[j];
            j = plus(j);
        }
        array = temp;
        head = 0;
        tail = size - 1;
    }

    // 环形数组下标变换公式
    private int plus(int index) {
        return (index + 1) % array.length;
    }

    private int minus(int index) {
        index--;
        if (index == -1) {
            return array.length - 1;
        }
        return index;
    }
}
