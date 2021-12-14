import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author cuterwrite
 * @date 2021/12/14-16:57
 */
public class FlikTest {
    @Test
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertFalse(Flik.isSameNumber(1, 2));
    }
}
