package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        if (rowIndex < 0)
            return res;
        // 加入第一个1
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            // 计算j+1位置的值，是根据j位置的值和j+1位置的值得到的，相当于往后位移一位
            for (int j = res.size() - 2; j >= 0; j--) {
                res.set(j + 1, res.get(j) + res.get(j + 1));
            }
            // 加上最后一个1
            res.add(1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(PascalTriangleII.getRow(3));
    }
}
// 参考：http://blog.csdn.net/linhuanmars/article/details/23311629
// https://segmentfault.com/a/1190000003803114
// http://www.cnblogs.com/felixfang/p/3865135.html