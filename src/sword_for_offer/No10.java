package sword_for_offer;

/**
 * 问题：求二进制数中1的个数
 * 思路：
 */
public class No10 {
    /**
     * 该解法如果输入时负数会陷入死循环，因为负数右移时，在最高位补得是1，二本题最终目的是求1的个数，那么会有无数个1了
     */
    public int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            // 用1和n进行位与运算，结果要是为1，则n的2进制形式最右边那位肯定是1，否则为0
            if ((n & 0x01) == 1) count++;
            // 右移一位
            n = n >> 1;
        }
        return count;
    }

    /**
     * 用1（1自身左移运算，其实后来就不是1了）和n的每位进行位与，来判断1的个数
     */
    public int numberOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) count++;
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 最优解法
     */
    public int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        No10 obj = new No10();
        System.out.println(obj.numberOfOne3(12));
    }
}
