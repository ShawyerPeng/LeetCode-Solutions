package array;

/**
 * https://leetcode.com/problems/container-with-most-water
 * 问题：给定n个非负整数a1,a2,...,an，其中每个代表一个点坐标（i,ai）。n个垂直线段例如线段的两个端点在（i,ai）和（i,0）。
 * 找到两个线段，与x轴形成一个容器，使其包含最多的水。
 * 思路：数组中的每个数对应一条线段的长度，索引对应 x 坐标，两个索引可以组成一个底部的宽，高度就是前面所说的线段的长度，
 * 而既然是要盛水，高度就是两个线段中较短的一个。
 * O(n) 的复杂度：保持两个指针 i,j；分别指向长度数组的首尾。如果 ai 小于 aj，则移动 i 向后（i++）。反之，移动 j 向前（j--）。
 * 如果当前的 area 大于了所记录的 area，替换之。
 * 这个想法的基础是，如果 i 的长度小于 j，无论如何移动 j，短板在 i，不可能找到比当前记录的 area 更大的值了，只能通过移动 i 来找到新的可能的更大面积。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;

        if (j <= 0) return 0;

        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));

            if (height[i] < height[j]) i++;
            else j--;
        }

        return maxArea;
    }

    public int maxAreaBruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int S = (j - i) * Math.min(height[i], height[j]);
                if (S > max) max = S;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        System.out.println(obj.maxArea(new int[]{1, 1}));
    }
}
// https://www.jianshu.com/p/87663edcf93a
// http://www.cnblogs.com/lichen782/p/leetcode_Container_With_Most_Water.html
// http://blog.csdn.net/nomasp/article/details/49081441