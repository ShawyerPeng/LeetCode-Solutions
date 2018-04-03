package two_pointers;

import java.util.*;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array
 * 问题：从给定数组中，找出所有差的绝对值为 k 的元素值对（i, j），返回元素值对的数量。
 * 思路：
 * 分析：时间复杂度：O(n)；空间复杂度：O(n)
 */
public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0 || k < 0) return count;
        Arrays.sort(nums);

        //int n = nums.length;
        //for (int i = 0; i < n; ++i) {
        //    int j = Math.max(j, i + 1);
        //    while (j < n && (long)nums[j] - nums[i] < k) ++j;
        //    if (j < n && (long)nums[j] - nums[i] == k) ++count;
        //    while (i < n - 1 && nums[i] == nums[i + 1]) ++i;
        //}

        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                if (nums[right] - nums[left] == k) {
                    count++;
                    while (nums[left] == nums[left + 1]) left++;
                    while (nums[right] == nums[right + 1]) right++;
                }
            }
        }
        return count;
    }

    public int findPairsHashMap(int[] nums, int k) {
        int count = 0;
        if (nums == null || nums.length == 0 || k < 0) return count;

        // 通过 HashMap 来存放各个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                // 注意 k = 0 时，应该判断是否有出现次数大于 2 的 Key ，若是 count++
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                //遍历 HashMap ，如遍历到 key1 ，检查是否存在为 key1 + k 的 Key ，若是 count++
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int findPairsSet(int[] nums, int k) {
        int len = nums.length, result = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Set<Integer> sameSet = new HashSet<>();
        if (k != 0) {
            for (int i = 0; i < len; i++) {
                if (!set.contains(nums[i]) && set.contains(nums[i] - k))
                    result++;
                set.add(nums[i]);
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (!sameSet.contains(nums[i]) && set.contains(nums[i])) {
                    result++;
                    sameSet.add(nums[i]);
                }
                set.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KDiffPairsInAnArray obj = new KDiffPairsInAnArray();
        System.out.println(obj.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(obj.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(obj.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }
}
