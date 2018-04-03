package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                if (Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                right = mid;
            }
        }
        int index = left;
        while (k != 0) {
            results.add(arr[index++]);
            k--;
        }
        return results;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = findLowerClosest(arr, x);
        int right = left + 1;

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (isLeftCloser(arr, x, left, right)) {
                results.add(arr[left]);
                left--;
            } else {
                results.add(arr[right]);
                right++;
            }
        }
        return results;
    }

    private boolean isLeftCloser(int[] arr, int x, int left, int right) {
        if (left < 0) return false;
        if (right >= arr.length) return true;
        if (x - arr[left] != arr[right] - x) {
            return x - arr[left] < arr[right] - x;
        }
        return true;
    }

    private int findLowerClosest(int[] arr, int target) {
        // find the last element smaller than target
        int start = 0, end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[end] < target) return end;
        if (arr[start] < target) return start;
        return -1;
    }

    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();
        if (arr == null || arr.length == 0) return results;
        if (arr.length == 1 && k == 1) {
            results.add(arr[0]);
            return results;
        }

        // left bound
        int left = 0;
        int right = arr.length - k - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                if (Math.abs(x - arr[mid]) > Math.abs(arr[mid + k] - x)) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                right = mid;
            }
        }

        int index;
        if (Math.abs(x - arr[left]) < Math.abs(x - arr[right]) || arr[left] == arr[right]) index = left;
        else index = right;
        while (k != 0) {
            results.add(arr[index++]);
            k--;
        }
        return results;
    }

    public static void main(String[] args) {
        FindKClosestElements obj = new FindKClosestElements();
        System.out.println(obj.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
        System.out.println(obj.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
        System.out.println(obj.findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2));
        System.out.println(obj.findClosestElements(new int[]{1, 1, 2, 3, 3, 3, 4, 6, 8, 8}, 6, 1));
    }
}
