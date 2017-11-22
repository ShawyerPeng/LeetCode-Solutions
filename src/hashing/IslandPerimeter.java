package hashing;

/**
 * https://leetcode.com/problems/island-perimeter
 * 问题：
 * 思路：
 */
public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int permeter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) permeter++;
                    if (i == n - 1 || grid[i + 1][j] == 0) permeter++;
                    if (j == 0 || grid[i][j - 1] == 0) permeter++;
                    if (j == m - 1 || grid[i][j + 1] == 0) permeter++;
                }
            }
        }
        return permeter;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }
}
// http://blog.csdn.net/mebiuw/article/details/53265123