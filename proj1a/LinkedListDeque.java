/**
 * @author cuterwrite
 * @date 2021/12/10-22:56
 */
public class LinkedListDeque<T> {
    private Node head;
    private Node end;
    private int size;

    public class Node {
        private Node prev;
        private Node next;
        private T item;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        head = end = null;
        size = 0;
    }

    public void addFirst(T item) {
        if (size == 0) {
            head = end = new Node(item, null, null);
            size += 1;
            return;
        }
        head.prev = new Node(item, null, head);
        head = head.prev;
        size += 1;
    }

    public void addLast(T item) {
        if (size == 0) {
            head = end = new Node(item, null, null);
            size += 1;
            return;
        }
        end.next = new Node(item, end, null);
        end = end.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public T removeLast() {
        if (end == null) {
            return null;
        }
        T item = end.item;
        end = end.prev;
        size--;
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur == null ? null : cur.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper(Node start, int index) {
        if (index == 0) {
            return start.item;
        }
        return getRecursiveHelper(start.next, index - 1);
    }
}
