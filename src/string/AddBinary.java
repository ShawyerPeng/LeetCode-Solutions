package string;

/**
 * https://leetcode.com/problems/add-binary
 * 问题：
 * 思路：二进制加法都是从最低位（从右加到左）。所以对两个字符串要从最后一位开始加，如果遇见长度不一的情况，就把短的字符串高位补 0.
 * 每轮计算要加上进位，最后跳出循环后要坚持进位是否为 1，以便更新结果。
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // 用了两个指针分别指向 a 和 b 的末尾，然后每次取出一个字符，转为数字，若无法取出字符则按 0 处理
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            // 对 2 取余即为当前位的数字
            sb.append(sum % 2);
            // 对 2 取商即为当前进位的值
            carry = sum / 2;
        }
        // 最后还要判断下 carry，如果为 1 的话，要在结果最前面加上一个 1
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("11", "1"));
    }
}
// http://www.cnblogs.com/springfor/p/3889228.html