package bit_manipulation;

/**
 * https://leetcode.com/problems/find-the-difference
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }



    public static void main(String[] args) {
        FindTheDifference obj = new FindTheDifference();
        System.out.println(obj.findTheDifference("abcd", "abcde"));
    }
}
