package two_pointers;

import java.util.*;

/**
 * https://leetcode.com/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //int left = 0, right = 0;
        //int max = Integer.MIN_VALUE;
        //while (right < nums.length) {
        //
        //}

        if (k <= 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k - 1; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) count = 1;
            else count++;
            map.put(nums[i], count);
        }
        // System.out.println(map);
        int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            Integer count = map.get(nums[j]);
            if (count == null) count = 1;
            else count++;
            map.put(nums[j], count);
            max[i] = map.lastKey();
            count = map.get(nums[j - k + 1]);
            count--;
            if (count == 0) map.remove(nums[j - k + 1]);
            else map.put(nums[j - k + 1], count);
            // System.out.println(map);
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int ri = 0;
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            // 每当新数进来时，如果发现队列头部的数的下标是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peek() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            // 把当前元素插入Deque
            deque.offer(i);
            // 队列头部就是该窗口内第一大的
            if (i >= k - 1) res[ri++] = nums[deque.peek()];
            //if (i >= k - 1) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(obj.maxSlidingWindow2(nums, 3)));
    }
}
