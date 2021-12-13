/**
 * @author cuterwrite
 * @created 2021/12/13-14:19
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        char[] chars = word.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!cc.equalChars(chars[i], chars[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
