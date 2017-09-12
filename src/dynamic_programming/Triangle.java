package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    // 自底向上求解
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            // 初始化最后一行
            dp[i] = triangle.get(n - 1).get(i);
        }

        // 从倒数第2行开始自底向上走
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 当前这个点的最小值，由他下面那一行临近的 2 个点的最小值与当前点的值相加得到
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        // 最终结果是第0行
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(Triangle.minimumTotal(triangle));
    }
}
// 参考：http://www.cnblogs.com/springfor/p/3887908.html
// http://ryanleetcode.blogspot.com/2015/06/triangle.html