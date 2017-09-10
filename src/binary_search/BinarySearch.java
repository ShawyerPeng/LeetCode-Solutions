package binary_search;

// 二分查找法是对一组有序的数字中进行查找，传递相应的数据，进行比较查找到与原数据相同的数据，
// 查找到了返回 1，失败返回对应的数组下标。
public class BinarySearch {
    public int binarySearchNonRec(int[] nums, int des) {
        // 第一个位置.
        int low = 0;
        // 最高位置.数组长度-1,因为下标是从0开始的.
        int high = nums.length - 1;
        // 当low"指针"和high不重复的时候.
        while (low <= high) {
            // 中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
            int middle = low + ((high - low) >> 1);
            // 与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.
            if (des == nums[middle]) {
                return middle;
                // 如果小于的话则移动最高层的"指针"
            } else if (des < nums[middle]) {
                high = middle - 1;
                // 移动最低的"指针"
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int binarySearchRec(int nums[], int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == nums[mid])
                return mid;
            else if (key < nums[mid])
                //移动low和high
                return binarySearchRec(nums, low, mid - 1, key);
            else if (key > nums[mid])
                return binarySearchRec(nums, mid + 1, high, key);
        } else
            return -1;
        return -1;
    }


    public static void main(String[] args) {
        int nums[] = new int[]{4,7,6,2,3,8,0,1,8,5,9,10};
        BinarySearch prob = new BinarySearch();
        System.out.println(prob.binarySearchNonRec(nums, 9));
        System.out.println(prob.binarySearchRec(nums, 0, nums.length-1, 9));
    }
}
// 参考：http://blog.csdn.net/lovesummerforever/article/details/24588989