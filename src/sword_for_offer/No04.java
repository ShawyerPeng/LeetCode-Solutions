package sword_for_offer;

/**
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 * 问题：替换空格。请实现一个函数，将一个字符串中的空格替换成 “%20”。例如，当字符串为 We Are Happy. 则经过替换之后的字符串为 We%20Are%20Happy。
 * 思路：先遍历找出空格总数，并计算出替换之后的字符串的总长度。然后从字符串的后面开始复制和替换。
 * 所有的字符都只复制移动一次，时间复杂度为 O(n)。
 */
public class No04 {
    public String replaceSpace(char[] charArray) {
        int n = charArray.length;

        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        char[] temp = new char[n + 2 * count];

        int j = n + 2 * count - 1;
        int i = n - 1;
        while (i >= 0) {
            if (charArray[i] == ' ') {
                temp[j] = '0';
                temp[j - 1] = '2';
                temp[j - 2] = '%';
                j = j - 3;

            } else {
                temp[j] = charArray[i];
                j--;
            }
            i--;
        }

        return new String(temp);
    }

    public static void main(String[] args) {
        No04 obj = new No04();
        System.out.println(obj.replaceSpace("We Are Happy".toCharArray()));
    }
}
// http://blog.csdn.net/derrantcm/article/details/45330797