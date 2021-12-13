/**
 * @author cuterwrite
 * @created 2021/12/13-14:19
 */
public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == N) || (y - x == N);
    }
}
