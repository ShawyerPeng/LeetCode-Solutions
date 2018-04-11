package array;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/third-maximum-number
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 如果加入成功，说明，否则去重
            if (set.add(num)) {
                queue.offer(num);
                // 把最小的poll出来，放入
                if (queue.size() > 3) queue.poll();
            }
        }
        if (queue.size() == 2) queue.poll();
        return queue.peek();
    }

    public static void main(String[] args) {
        ThirdMaximumNumber obj = new ThirdMaximumNumber();
        System.out.println(obj.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
