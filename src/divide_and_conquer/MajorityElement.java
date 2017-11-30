package divide_and_conquer;

import java.util.*;

/**
 * https://leetcode.com/problems/majority-element
 * 问题：给定一个长度为 n 的数组，寻找其中的 “众数”。众数是指出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 思路：方法很多，可以排序、哈希表、分治等等。
 * 分治解法：
 * 首先将序列均分成两半，分别找出每一半的主元素。如果两个主元素相等，则直接返回 1 个；否则遍历完整序列，返回出现次数多于一半的那个主元素。
 * 边界条件：序列只有一个元素时，直接返回该元素。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        return majority(nums, 0, nums.length - 1);

        //List<Integer> vec1 = new ArrayList<>();
        //for (int i = 0; i < nums.length / 2; i++) {
        //    vec1.add(nums[i]);
        //}
        //int me1 = majorityElement(vec1.toArray());
        //for (int i = 0; i < nums.length / 2; i++) {
        //    vec1.add(nums[i]);
        //}
        //int me2 = majorityElement(vec2);
        //if (me1 == me2) return me1;
        //else {
        //    int cnt = 0;
        //    for (int i = 0; i < nums.length; ++i) if (me1 == nums[i]) cnt++;
        //    if (cnt > nums.length / 2) return me1;
        //    return me2;
        //}
    }

    private int majority(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + ((right - left) >> 1);
        int lm = majority(nums, left, mid);
        int rm = majority(nums, mid + 1, right);
        if (lm == rm) return lm;

        int cnt = 0;
        for (int i = 0; i < nums.length; i++) if (lm == nums[i]) cnt++;

        if (cnt > nums.length / 2) return lm;
        return rm;
    }

    /**
     * HashMap
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int item : map.keySet()) {
            if (map.get(item) > nums.length / 2) {
                return item;
            }
        }

        return 0;

        //int max_count = 0;
        //int result = 0;
        //
        //Iterator it = map.entrySet().iterator();
        //while (it.hasNext()) {
        //    Map.Entry entry = (Map.Entry) it.next();
        //    if ((int) entry.getValue() > max_count) {
        //        result = (int) entry.getKey();
        //        max_count = (int) entry.getValue();
        //    }
        //}
        //return result;
    }


    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement(new int[]{1, 1, 1, 1, 1, 2, 3, 4, 5, 6}));
    }
}
// http://www.voidcn.com/article/p-vvdwyztd-bpd.html
// http://kuring.me/post/majority_element/