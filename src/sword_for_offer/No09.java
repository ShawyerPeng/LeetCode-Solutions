package sword_for_offer;

/**
 * 问题：斐波那契数列。
 * 思路：从下往上计算，先根据f(0)+f(1)算出f(2)，以此类推。从第 2 项开始，每一项都等于前两项之和。（第 0 项是 0，第一项是 1）
 */
public class No09 {
    public int getfibN(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int fibNone = 1;
        int fibNtwo = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibNone + fibNtwo;
            fibNtwo = fibNone;
            fibNone = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        No09 obj = new No09();
        System.out.println(obj.getfibN(5));
    }
}
// http://blog.csdn.net/abc7845129630/article/details/52700905