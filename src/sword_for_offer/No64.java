package sword_for_offer;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream
 * 问题：数据流中的中位数
 * 思路：
 */
public class No64 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
        int size = maxHeap.size() + minHeap.size();
        // 若元素总个数为偶数，则插入最小堆中
        if ((size & 1) == 0) {
            // 如果新数据比最大堆中的一些数据小，先把它插入到最大堆中，然后把最大堆中的最大数拿出来插入到最小堆中
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            // 如果新数据比最小堆中的一些数据大，先把它插入到最小堆中，然后把最小堆中的最小数拿出来插入到最大堆中
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if (size == 0)
            throw new RuntimeException("no available number!");
        if ((size & 1) == 1)
            // 总数为奇数时，[大顶堆堆顶]就是中位数
            return minHeap.peek();
        else
            // 总数为偶数时，[大顶堆堆顶和小顶堆堆顶的平均值]就是中位数
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    public void addNum2(int num) {
        // 如果最大堆为空，或者该数小于最大堆堆顶，则加入最大堆
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            // 如果最大堆大小超过最小堆，则要平衡一下
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            maxHeap.offer(num);
            // 数字大于最小堆堆顶，加入最小堆的情况
        } else if (minHeap.size() == 0 || num > minHeap.peek()) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            minHeap.offer(num);
            // 数字在两个堆顶之间的情况
        } else {
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public double findMedian2() {
        // 返回大小较大的那个堆堆顶，如果大小一样说明是偶数个，则返回堆顶均值
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        No64 obj = new No64();
        int[] nums = new int[]{1, 4, 7, 5, 2, 3, 9, 6};
        for (int num : nums) {
            obj.addNum(num);
            System.out.println(obj.findMedian());
        }
    }
}
// https://segmentfault.com/a/1190000003709954