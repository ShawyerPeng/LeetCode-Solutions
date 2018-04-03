package heap;

import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 * 问题：给定一个非空的整型数组，返回出现频率次数排在前k的元素
 * 思路：
 * 扫描一遍统计频率；排序找到前k个出现频率最高的元素。 O(nlogn)
 * 维护一个含有k个元素的优先队列。如果遍历到的元素比队列中的最小频率元素的频率高，则取出队列中最小频率的元素，将新元素入队。最终，队列中剩下的，就是前k个出现频率最高的元素。维护优先队列，时间复杂度：O(nlogk)
 */
public class TopKFrequentElements {
    /**
     * 大根堆
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        // 生成最大堆使用o2-o1,生成最小堆使用o1-o2
                        return o2.getValue() - o1.getValue();
                    }
                });

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 未达到最大容量，直接添加
            if (maxHeap.size() < k) {
                maxHeap.offer(entry);
            } else if (maxHeap.peek().getValue() < entry.getValue()) {
                // 将新元素与当前堆顶元素比较，保留较大的元素
                maxHeap.poll();
                maxHeap.offer(entry);
            }
        }

        List<Integer> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : maxHeap) {
            results.add(entry.getKey());
        }
        while (!maxHeap.isEmpty()) {
            results.add(0, maxHeap.poll().getKey());
        }
        return results;
    }

    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();
        System.out.println(obj.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}
// https://www.youtube.com/watch?v=lm6pBga98-w
// https://www.youtube.com/watch?v=oYqTe_DQA34
// https://www.youtube.com/watch?v=EYFcQRwcqk0