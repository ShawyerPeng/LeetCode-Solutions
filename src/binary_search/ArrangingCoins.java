package binary_search;

/**
 * https://leetcode.com/problems/arranging-coins
 * 问题：有n枚硬币，铸成阶梯型（第k行有k枚硬币），返回能被铸的完整阶梯的行数，（如果最后一行硬币不足则不包含）
 * 思路：
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 1) return n;

        int start = 0;
        int end = n;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // mid的类型为long，一定注意！
            long midVal = (long) mid * (mid + 1) / 2;
            if (midVal == n) {
                return mid;
            } else if (midVal > n) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (end * (end + 1) / 2 <= n)
            return end;
        else
            return start;
    }

    /**
     * 通常的方法
     */
    public int arrangeCoins2(int n) {
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum <= n)
                start = mid + 1;
            else
                end = mid - 1;

        }

        return end;
        //return start - 1;
    }

    public int arrangeCoins3(int n) {
        int start = 0;
        int end = n + 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = mid * (mid + 1) / 2;
            if (sum > n)
                end = mid;
            else if (sum <= n)
                start = mid + 1;
        }

        return start - 1;
    }

    public int arrangeCoins4(int n) {
        long low = 1, high = n;
        while (low < high) {
            // mid的类型为long，一定注意！
            long mid = low + (high - low + 1) / 2;
            if ((mid + 1) * mid / 2.0 <= n)
                low = mid;
            else high = mid - 1;
        }
        return (int) high;
    }

    public static void main(String[] args) {
        ArrangingCoins obj = new ArrangingCoins();
        System.out.println(obj.arrangeCoins(1804289383));
        System.out.println(obj.arrangeCoins(8));
        System.out.println(obj.arrangeCoins2(1804289383));
        System.out.println(obj.arrangeCoins2(8));
        System.out.println(obj.arrangeCoins3(5));
        System.out.println(obj.arrangeCoins3(8));
        System.out.println(obj.arrangeCoins4(5));
        System.out.println(obj.arrangeCoins4(8));
    }
}
// http://hongzheng.me/leetcode/leetcode-441-arranging-coins/
// http://bookshadow.com/weblog/2016/10/30/leetcode-arranging-coins/