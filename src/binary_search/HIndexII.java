package binary_search;

/**
 * https://leetcode.com/problems/h-index-ii
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid)
                return len - mid;
            else if (citations[mid] < len - mid)
                left = mid;
            else
                right = mid;
        }
        if (citations[left] >= len - left) return len - left;
        if (citations[right] >= len - right) return len - right;
        return 0;
    }

    public static void main(String[] args) {
        HIndexII obj = new HIndexII();
        System.out.println(obj.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(obj.hIndex(new int[]{100}));
    }
}
