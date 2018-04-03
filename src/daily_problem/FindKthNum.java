package daily_problem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 问题：
 * 思路：
 * 分析：
 * 时间复杂度：快速排序平均所费时间为n*logn，从小到大排序这n个数，然后再遍历序列中后k个元素输出，即可，总的时间复杂度为O(n*logn+k)=O(n*logn)
 */
public class FindKthNum {
    public int findKthNum(int[] num, int len, int k) {
        return quickSort(num, 0, len - 1, k);
    }

    private int quickSort(int[] num, int low, int high, int k) {
        if (low <= high) {
            int pos = partition(num, low, high);
            // 递归结束，找到第K大的数
            if (pos == k - 1)
                return num[pos];
                // 递归调用，在前面部分查找第K大的数
            else if (pos > k - 1)
                return quickSort(num, low, pos - 1, k);
                // 递归调用，在后面部分查找第K大的数
            else
                return quickSort(num, pos + 1, high, k);
        } else
            return -1;
    }

    /**
     * 求第K大时在（1）（2）中按从大到小排序、求第K小时在（1）（2）中按从小到大排序，只改变大于号、小于号即可。
     * 现在是从大到小排序求第K大
     */
    private int partition(int[] num, int low, int high) {
        int tmp = num[low];
        while (low < high) {
            while ((low < high) && tmp >= num[high])//（1）
                high--;
            num[low] = num[high];
            while ((low < high) && tmp <= num[low]) //（2）
                low++;
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }

    public int findKthNum(int[] input, int k) {
        int length = input.length;
        if (k > length || k == 0) return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }

        int count = 0;
        for (Integer integer : maxHeap) {
            if (++count == k)
                return integer;
        }
        return 0;
    }

    public ArrayList<Integer> getKLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k == 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {
        FindKthNum obj = new FindKthNum();
        System.out.println(obj.findKthNum(new int[]{1, 3, 5, 2, 2}, 5, 3));
        System.out.println(obj.findKthNum(new int[]{1, 3, 5, 2, 2}, 3));
        System.out.println(obj.getKLeastNumbers(new int[]{1, 3, 5, 2, 2}, 3));
    }
}
// http://blog.csdn.net/u012050154/article/details/53196068