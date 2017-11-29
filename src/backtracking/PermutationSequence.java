package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence
 * 问题：给定一个集合[1,2,3,…,n]，包含了n!个不同的全排列permutations，列出第k个permutation
 * 思路：
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int mod = 1;
        List<Integer> candidates = new ArrayList<>();
        // 先得到n!和候选数字列表
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
            candidates.add(i);
        }
        // 将k先减1方便整除
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            // 得到当前应选数字的序数
            int first = k / mod;
            // 得到用于计算下一位的k
            k = k % mod;
            sb.append(candidates.get(first));
            // 在列表中移出该数字
            candidates.remove(first);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence obj = new PermutationSequence();
        for (int k = 1; k <= 6; k++)
            System.out.println(obj.getPermutation(3, k));
    }
}
// https://segmentfault.com/a/1190000003766760