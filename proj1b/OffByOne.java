/**
 * @author cuterwrite
 * @created 2021/12/13-14:19
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
