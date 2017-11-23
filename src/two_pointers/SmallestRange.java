package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/smallest-range
 * 问题：给定 k 组递增排列的整数。求最小范围，使得每组数中至少有一个包含在其中。
 * 思路：
 * 用一个哈希表来建立每个数组与其数组中数字出现的个数之间的映射
 */
public class SmallestRange {
    //public static int[] smallestRange(List<List<Integer>> nums) {
    //    ArrayList<Integer> result = new ArrayList<>();
    //    // 初始化一个长度为 0 的窗口
    //    int left = 0, right = 0, count = p.length();
    //
    //    // 构造一个 map，对于 p 中的每个字符 char，都有 map[char]++
    //    int[] map = new int[256];
    //    // 初始化map
    //    for (char c : p.toCharArray()) map[c]++;
    //
    //    // 滑动窗口
    //    char[] sc = s.toCharArray();
    //
    //    while (right < s.length()) {
    //        // 1：扩展窗口，right，窗口中包含一个T中子元素，count--
    //        if (map[sc[right++]]-- >= 1) count--;
    //        // 2：通过count或其他限定值，得到一个可能解。
    //        if (count == 0) result.add(left);
    //        // 3：只要窗口中有可能解，那么缩小窗口直到不包含可能解。
    //        if (right - left == p.length() && map[sc[left++]]++ >= 0) count++;
    //    }
    //    return result;
    //}

    public static int[] smallestRangePriorityQueue(List<List<Integer>> nums) {
        int n = nums.size();
        //int[] 三个元素的数组，分别存 [value,k(位于第几个 list),index(位于第 k 个 list 中的第 index 位)]
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        int minRange = Integer.MAX_VALUE;
        int minRange_min = Integer.MAX_VALUE;
        int minRange_max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            queue.offer(new int[]{val, i, 0});
        }
        while (minRange != 0) {
            int[] now_min = queue.poll();//// now_min 指当前 queue 中的最小元素
            if (max - now_min[0] < minRange) {
                minRange = max - now_min[0];
                minRange_min = now_min[0];
                minRange_max = max;
            }
            int k = now_min[1];
            int index = now_min[2];
            index += 1;
            if (index == nums.get(k).size()) {
                break;
            }
            int val = nums.get(k).get(index);
            if (val > max) {
                max = val;
            }
            queue.offer(new int[]{val, k, index});
        }

        return new int[]{minRange_min, minRange_max};
    }

    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(4);list1.add(10);list1.add(15);list1.add(24);list1.add(26);
        List<Integer> list2=new ArrayList<>();
        list2.add(0);list2.add(9);list2.add(12);list2.add(20);
        List<Integer> list3=new ArrayList<>();
        list3.add(5);list3.add(18);list3.add(22);list3.add(30);
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(list1);nums.add(list2);nums.add(list3);

        System.out.println(Arrays.toString(smallestRangePriorityQueue(nums)));
    }
}
// http://blog.csdn.net/huanghanqian/article/details/74765018