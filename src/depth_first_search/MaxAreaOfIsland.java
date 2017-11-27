package depth_first_search;

/**
 * https://leetcode.com/problems/max-area-of-island
 * 问题：给定非空矩阵，元素为 0 或 1，1 代表陆地，四个方向中若有陆地相连，则代表区域，求最大区域的面积。
 * 思路：用 DFS 算法实现每个区域的面积，这里利用递归实现，计算过的陆地则变为 0；
 * 遍历图中所有的元素，记录当前最大的面积。
 */
public class MaxAreaOfIsland {
    private int count = 0;
    private int result = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) continue;
                count = 0;
                dfs(grid, i, j);
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int row = grid.length, col = grid[0].length;
        // 边界溢出或不满足“岛”的条件
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != 1) return;
        // 更新最大面积
        result = Math.max(result, ++count);
        // 遍历过后变为-1
        grid[i][j] = -1;
        // 四个方向 dfs
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }

    public int maxAreaOfIsland2(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 1) continue;
                count = 0;
                maxArea = Math.max(maxArea, dfs2(grid, i, j));
            }
        }
        return result;
    }

    private int dfs2(int[][] grid, int i, int j) {
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        // 边界溢出或不满足“岛”的条件
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] != 0) {
            // 遍历过后变为-1
            grid[i][j] *= -1;
            // 四个方向 dfs
            for (int[] dir : dirs) {
                result += dfs2(grid, i + dir[0], j + dir[1]);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        int[][] nums = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(obj.maxAreaOfIsland(nums));
        System.out.println(obj.maxAreaOfIsland2(nums));
    }
}
// http://www.cnblogs.com/grandyang/p/7712724.html
// http://blog.csdn.net/thesnowboy_2/article/details/78173867
// https://koalatree.github.io/2017/10/26/LeetCode-695%EF%BC%9AMax%20Area%20of%20Island%20%EF%BC%88%E5%B2%9B%E7%9A%84%E6%9C%80%E5%A4%A7%E9%9D%A2%E7%A7%AF%EF%BC%89/