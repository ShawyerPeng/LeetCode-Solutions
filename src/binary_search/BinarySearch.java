package binary_search;

// 二分查找法是对一组有序的数字中进行查找，传递相应的数据，进行比较查找到与原数据相同的数据，
// 查找到了返回1，失败返回对应的数组下标。
public class BinarySearch {
    // 二分法更通用的模板
    // https://www.jiuzhang.com/qa/65/
    // https://www.jiuzhang.com/qa/303/
    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {   // start和end相邻或相交，在任何情况下都不会死循环
            // 这样写不会有溢出的情况
            mid = start + (end - start) / 2;
            // 如果start + end是一个接近于MAXINT的数，会溢出
            // mid = (start + end) / 2;
            if (nums[mid] == target)    // 前面可能还有一个相等的数
                end = mid;
            else if (nums[mid] < target)
                start = mid;
            else if (nums[mid] > target)
                end = mid;
        }

        // 再做一层判断
        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;

        return -1;
    }

    public static int binarySearchNonRec(int[] nums, int target) {
        // 第一个位置
        int low = 0;
        // 最高位置.数组长度-1,因为下标是从0开始的.
        int high = nums.length - 1;
        // 当low"指针"和high不重复的时候.
        while (low <= high) {
            // 中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
            int middle = low + ((high - low) >> 1);
            // 与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.
            if (target == nums[middle]) {
                return middle;
                // 如果小于的话则移动最高层的"指针"
            } else if (target < nums[middle]) {
                high = middle - 1;
                // 移动最低的"指针"
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int nums[], int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == nums[mid])
                return mid;
            else if (key < nums[mid])
                // 移动low和high
                return binarySearchRec(nums, low, mid - 1, key);
            else if (key > nums[mid])
                return binarySearchRec(nums, mid + 1, high, key);
        } else
            return -1;
        return -1;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{4, 7, 6, 2, 3, 8, 0, 1, 8, 5, 9, 10};
        System.out.println(binarySearchNonRec(nums, 9));
        System.out.println(binarySearchRec(nums, 0, nums.length - 1, 9));

        int nums2[] = new int[]{1, 2, 3, 3, 4, 5, 10};
        System.out.println(binarySearch(nums2, 3));
    }
}
// 参考：http://blog.csdn.net/lovesummerforever/article/details/24588989