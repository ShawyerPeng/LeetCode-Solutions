package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestElementInAnArray {
    public int findKthLargest0(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition0(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    private int partition0(int[] nums, int left, int right) {
        // 设置pivot为要排序数组的第一个元素，即第一趟排序后，pivot左边的数全部比pivot小，pivot右边的数全部比pivot大
        int pivot = nums[left];
        // 设置数组左边的索引，往右移动判断比key大的数（注意此处要加上1）
        int i = left + 1;
        // 设置数组右边的索引，往左移动判断比key小的数
        int j = right;
        // 如果左边索引比右边索引小，则还有数据没有排序
        // 等号用于当只有两个元素比如 0,6的排序,如果不加等号,排序后会交换0和6从而产生错误
        while (i <= j) {
            // 从大到小排序，即把大于pivot的数放到它左边
            if (nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i++, j--);
            }
            if (nums[i] >= pivot) i++;
            if (nums[j] <= pivot) j--;
        }
        // 将nums[left]和nums[j]交换，此时j停留在需要交换的位置，i的位置不定，可能比j大也可能和j相等
        swap(nums, left, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // mid是小于pivot的元素的个数
            int mid = partition(nums, left, right);
            // 如果左边的数个数小于k，说明第k个元素在右边，否则在左边
            if (mid == k - 1) {
                // 为了找到第k大元素，需要有k-1个元素比它大
                return nums[mid];
            } else if (mid > k - 1) {
                // 目标在左半边数组
                right = mid - 1;
            } else {
                // 目标在右半边数组
                left = mid + 1;
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        //Random rand = new Random();
        //int index = rand.nextInt(right - left + 1) + left;
        //int pivot = nums[index];
        //swap(nums, index, left);
        // 先取左端点作pivot，取出值后，该位置可视为待填充位置
        int pivot = nums[left];
        int i = left;   // 左边标志位
        int j = right;  // 右边标志位
        while (i <= j) {
            // 从左向右找到第一个大于枢纽值的数
            if (i <= j && nums[i] >= pivot) i++;
            // 从右向左找到第一个小于枢纽值的数
            if (i <= j && nums[j] <= pivot) j--;
            // 从大到小排序，即把大于pivot的数放到它左边
            if (i <= j && nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i++, j--);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // mid是小于pivot的元素的个数
            int mid = partition1(nums, left, right);
            if (mid == k - 1) {
                // 为了找到第k大元素，需要有k-1个元素比它大
                return nums[mid];
            } else if (mid > k - 1) {
                // 目标在左半边数组
                right = mid - 1;
            } else {
                // 目标在右半边数组
                left = mid + 1;
            }
        }
        return nums[left];
    }

    private int partition1(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left;   // 左边标志位
        int j = right;  // 右边标志位
        while (i < j) {
            // 从大到小排序，即把大于pivot的数放到它左边
            if (i < j && nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i++, j--);
            }
            if (nums[i] >= pivot) i++;
            if (nums[j] <= pivot) j--;
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            // 如果添加一个元素后最小堆已经满了，只能poll一个最小值出来，以维持只有k个元素的堆
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 容量为k的最小堆的最小元素就是数组的第k大元素
        return minHeap.peek();
    }

    /**
     * 在数字集合中寻找第k大，可以考虑用Max Heap，将数组遍历一遍，加入到一个容量为k的PriorityQueue
     * 最后poll() k-1次，那么最后剩下在堆顶的就是kth largest的数字了。
     */
    public int kthLargestElement3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int j = 0; j < k - 1; j++) {
            heap.poll();
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray obj = new KthLargestElementInAnArray();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(obj.findKthLargest(new int[]{2, 1}, 1));
        System.out.println(obj.findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 2));
    }
}
