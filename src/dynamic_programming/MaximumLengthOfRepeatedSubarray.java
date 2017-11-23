package dynamic_programming;

/**
 * Created by ShawyerPeng on 2017/11/23.
 */
public class MaximumLengthOfRepeatedSubarray {
    public static int findLength(int[] A, int[] B) {
        int ans = 0;
        int[] dp = new int[A.length + 1];
        for (int j = 1; j <= B.length; j++) {
            for (int i = A.length; i >= 1; i--) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 0;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        System.out.println(findLength(A, B));
    }
}
// http://blog.csdn.net/Koala_Tree/article/details/78488711
// http://blog.jerkybible.com/2017/10/31/LeetCode-718-Maximum-Length-of-Repeated-Subarray/