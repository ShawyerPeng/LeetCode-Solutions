package sword_for_offer;

/**
 * 问题：从 1 到 n 整数中 1 出现的次数
 * 思路：
 */
public class No32 {
    public int NumberOf1Between1AndN(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            // 之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            // 当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    public static void main(String[] args) {
        No32 obj = new No32();
        System.out.println(obj.NumberOf1Between1AndN(12));
    }
}
// http://www.voidcn.com/article/p-ycrfggua-ko.html
// http://www.jianshu.com/p/25f33c14297f