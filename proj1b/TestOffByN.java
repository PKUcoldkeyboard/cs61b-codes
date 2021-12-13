import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cuterwrite
 * @created 2021/12/13-15:06
 */
public class TestOffByN {

    static Palindrome palindrome = new Palindrome();
    static OffByN offByN = new OffByN(5);

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("bidding", offByN));
    }
}
