package sword_for_offer;

/**
 * https://www.nowcoder.com/questionTerminal/bd7f978302044eee894445e244c7eee6
 * 问题：整数中1出现的次数（从1到n整数中1出现的次数）
 * 思路：
 */
public class No32 {
    public int numberOf1Between1AndN(int n) {
        int count = 0;
        // i表示当前分析的是哪一个数位
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            // 之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            // 当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    public int NumberOf1Between1AndN(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            if (a % 10 == 0)
                count += a / 10 * i;
            else if (a % 10 == 1)
                count += (a / 10 * i) + (b + 1);
            else
                count += (a / 10 + 1) * i;
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        // 当前位
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10; // 高位数字
            before = n / (i * 10);  // 当前位数字
            after = n - (n / i) * i;// 低位数字
            // 如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before * i;
                // 如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if (current == 1)
                count += before * i + after + 1;
                // 如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else {
                count += (before + 1) * i;
            }
            // 前移一位
            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        No32 obj = new No32();
        System.out.println(obj.NumberOf1Between1AndN(13));
    }
}
// http://www.voidcn.com/article/p-ycrfggua-ko.html
// http://www.jianshu.com/p/25f33c14297f