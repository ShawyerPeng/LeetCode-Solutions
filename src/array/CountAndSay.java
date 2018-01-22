package array;

/**
 * https://leetcode.com/problems/count-and-say
 * 问题：
 * 思路：
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n <= 0) return "";

        String curRes = "1";
        int start = 1;// 从 1 开始算
        while (start < n) {
            StringBuilder res = new StringBuilder();
            int count = 1;
            for (int j = 1; j < curRes.length(); j++) {
                if (curRes.charAt(j) == curRes.charAt(j - 1))
                    count++;
                else {
                    res.append(count);
                    res.append(curRes.charAt(j - 1));
                    count = 1;
                }
            }
            res.append(count);
            res.append(curRes.charAt(curRes.length() - 1));
            curRes = res.toString();
            start++;
        }
        return curRes;
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(4));
    }
}
// http://www.cnblogs.com/springfor/p/3889221.html
// http://www.cnblogs.com/higerzhang/p/4050290.html