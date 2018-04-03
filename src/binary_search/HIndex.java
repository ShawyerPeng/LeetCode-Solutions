package binary_search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index
 */
public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        // 从后往前遍历
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        HIndex obj = new HIndex();
        System.out.println(obj.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
