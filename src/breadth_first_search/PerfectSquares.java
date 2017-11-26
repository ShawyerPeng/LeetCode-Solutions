package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/perfect-squares
 * 问题：找到一个数最少需要的平方和数字的个数
 * 思路：BFS 或动态规划
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int result = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                // 将 temp 值为队首的值
                int temp = queue.poll();
                // 再从后往前检索所有平方小于 temp 的数，并把他们逐一入队
                for (int i = new Double(Math.sqrt(temp)).intValue(); i >= 1; i--) {
                    // 直到有一次入队时候发现该数字为 0 时 return
                    if (i * i == temp) return result;
                    queue.offer(temp - i * i);
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        PerfectSquares obj = new PerfectSquares();
        System.out.println(obj.numSquares(12));
        System.out.println(obj.numSquares(13));
    }
}
