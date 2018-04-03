package binary_search;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 问题：
 * 思路：
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int count = count(matrix, mid);
            if (count < k)
                left = mid;
            else
                right = mid;
        }
        if (count(matrix, right) <= k - 1) return right;
        else return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n && matrix[i][j] < target) j++;
            result += j;
        }
        return result;
    }

    private int count2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        int result = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                result += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix obj = new KthSmallestElementInASortedMatrix();
        System.out.println(obj.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }
}
