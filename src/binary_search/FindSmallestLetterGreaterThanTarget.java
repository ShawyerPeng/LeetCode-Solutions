package binary_search;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target
 * 问题：找比目标值大的最小字母。有序字符数组，如果没有直接返回最小的字符（第一个字符）
 * 思路：
 */
public class FindSmallestLetterGreaterThanTarget {
    /**
     * 二分法左闭右开区间
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        // l==r<n表示找到了解；l==r==n表示当前数组中没有比target大的，直接返回第一个元素
        // 其实等价于return letters[left % n]
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 中间元素<=target，表示不是想要的解（第一个大于target的元素）
            if (letters[mid] <= target)
                // 搜索空间往右移
                left = mid + 1;
            else if (letters[mid] >= target)
                // 搜索空间往左移
                right = mid;
        }
        // l!=n时，返回l；l==n时，返回0
        return letters[left % letters.length];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        // l==r<n表示找到解了；l==r==n表示当前数组中没有比target大的，直接返回第一个元素
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 中间元素<=target，表示不是想要的解（第一个大于target的元素）
            if (letters[mid] <= target)
                left = mid;
            else if (letters[mid] > target)
                right = mid;
        }

        if (letters[left] > target) return letters[left];
        else if (letters[right] > target) return letters[right];
        else return letters[0];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget obj = new FindSmallestLetterGreaterThanTarget();
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(obj.nextGreatestLetter2(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
