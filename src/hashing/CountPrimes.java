package hashing;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes
 * 问题：给定一个非负数 n，让我们求小于 n 的质数的个数
 * 思路：埃拉托斯特尼筛法
 * 如果一个数是另一个数的倍数，那这个数肯定不是素数。
 * 利用这个性质，我们可以建立一个素数数组，从 2 开始将素数的倍数都标注为不是素数。
 * 第一轮将 4、6、8 等表为非素数，然后遍历到 3，发现 3 没有被标记为非素数，则将 6、9、12 等标记为非素数
 * 一直到 N 为止。再数一遍素数数组中有多少素数。
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                // 将i的2倍、3倍、4倍...都标记为非素数
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(20));
    }
}
// https://segmentfault.com/a/1190000003709122
// http://www.cnblogs.com/grandyang/p/4462810.html