import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author cuterwrite
 * @created 2021/12/13-16:47
 */
public class TestArrayDequeGold {
    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDeque = new ArrayDequeSolution<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            if (arrayDeque.isEmpty()) {
                int addNumber = StdRandom.uniform(1000);
                int ops = StdRandom.uniform(2);
                if (ops == 0) {
                    // addFirst operation
                    sb.append("addFirst(").append(addNumber).append(")\n");
                    studentDeque.addFirst(addNumber);
                    arrayDeque.addFirst(addNumber);
                } else {
                    // addLast operation
                    sb.append("addLast(").append(addNumber).append(")\n");
                    studentDeque.addLast(addNumber);
                    arrayDeque.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testRemoveNumber = 1;
                Integer stdRemoveNumber = 1;
                switch (x) {
                    case 0:
                        sb.append("addFirst(").append(addNumber).append(")\n");
                        studentDeque.addFirst(addNumber);
                        arrayDeque.addFirst(addNumber);
                        break;
                    case 1:
                        sb.append("addLast(").append(addNumber).append(")\n");
                        studentDeque.addLast(addNumber);
                        arrayDeque.addLast(addNumber);
                        break;
                    case 2:
                        sb.append("removeFirst()\n");
                        testRemoveNumber = studentDeque.removeFirst();
                        stdRemoveNumber = arrayDeque.removeFirst();
                        break;
                    case 3:
                        sb.append("removeLast()\n");
                        testRemoveNumber = studentDeque.removeLast();
                        stdRemoveNumber = arrayDeque.removeLast();
                        break;
                    default:
                        break;
                }
                assertEquals(sb.toString(), testRemoveNumber, stdRemoveNumber);
            }
        }
    }
}
