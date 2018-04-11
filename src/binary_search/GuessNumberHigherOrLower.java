package binary_search;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower
 * 问题：
 * 思路：
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 1)
                // 数字小了，应该选个大点的
                left = mid;
            else if (guess(mid) == -1)
                // 数字大了，应该选个小点的
                right = mid;
            else
                return mid;
        }
        if (guess(left) == 0) return left;
        return right;
    }

    public int guess(int n) {
        return -1;
    }
}