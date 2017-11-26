package hashing;

/**
 * https://leetcode.com/problems/bulls-and-cows
 * 问题：
 * 思路：用哈希表，来建立数字和其出现次数的映射
 */
public class BullsAndCows {
    public static String getHint(String secret, String guess) {
        int m[] = new int[256], bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) ++bulls;
            else {
                if (m[secret.charAt(i)]++ < 0) ++cows;
                if (m[guess.charAt(i)]-- > 0) ++cows;
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
    }
}
// http://www.cnblogs.com/grandyang/p/4929139.html