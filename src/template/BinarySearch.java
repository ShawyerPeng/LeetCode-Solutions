package template;

public class BinarySearch {
    // First Index
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] < target)
                left = mid;
            else if (nums[mid] > target)
                right = mid;
        }

        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;

        return -1;
    }

    // Last Index
    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid;
            else if (nums[mid] < target)
                left = mid;
            else if (nums[mid] > target)
                right = mid;
        }

        if (nums[right] == target)
            return right;
        if (nums[left] == target)
            return left;

        return -1;
    }

    /**
     * 右值点不能取到的情况 左闭右开[left，right)
     */
    public static int binarySearch3(int[] nums, int target) {
        //坑点1 right究竟能不能取到的问题，这里是不能取到的情况
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;//坑点2 这里尽量这么写，因为如果写成(i+j)/2则有溢出的风险
            if (nums[mid] >= target)//坑点3 这个地方大于还是大于等于要依据情况而定
                right = mid;//坑点4 因为右值点反正不能取到，所以j就可以等于mid
            else if (nums[mid] < target)
                left = mid + 1;//坑点5
        }
        return left;
    }

    /**
     * 右值点能取到的情况 全闭区间[left，right]
     */
    public static int binarySearch4(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] < target)
                left = mid;
            else if (nums[mid] > target)
                right = mid;

            if (nums[mid] >= target)
                right = mid - 1;
            else
                // nums[mid]!=target，所以target必然在[mid+1,right]之间，果断地+1，不要用left=mid;这里我们都用闭区间。
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 2, 4, 8, 10};
        System.out.println(BinarySearch.binarySearch4(nums, 2));
    }
}
