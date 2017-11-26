package breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/number-of-islands
 * 问题：给一个 01 矩阵，求不同的岛屿的个数。
 * 0 代表水，1 代表岛，如果两个 1 相邻，那么这两个 1 属于同一个岛。我们只考虑上下左右为相邻。
 * 思路：本质是求矩阵中连续区域的个数。DFS比BFS更好。
 */
public class NumberOfIslands {
    /**
     * BFS
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int res = 0;
        int row = grid.length, col = grid[0].length;

        // 初始化visited数组，初始化为 false，表示所有的点均没有访问过
        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<Integer> queue = new ArrayDeque<>();

        // 2 层 for 循环遍历 grid 数组，遇到没有被访问过的‘1’之后，开始利用 BFS 思路遍历 1 周围的 1，并将其标记为已访问。
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果该位置是“水”或者已经被访问过，跳过
                if (grid[i][j] == '0' || visited[i][j]) continue;

                // 如果该处(第i列，第j行)是“岛”并且没有被访问过，则添加当前位置到queue中，并且访问次数加一
                int loc = i * col + j;
                queue.add(loc);
                res += 1;
                // 从该点开始进行 BFS
                while (!queue.isEmpty()) {
                    loc = queue.poll();
                    // 列数，即横坐标
                    int tpx = loc / col;
                    // 行数，即纵坐标
                    int tpy = loc % col;

                    // 如果已访问则跳过
                    if (visited[tpx][tpy]) continue;
                    // 标记为已访问
                    visited[tpx][tpy] = true;

                    // 分别向上下左右四个方向 BFS
                    for (int k = 0; k < 4; k++) {
                        int x = tpx + directions[k][0];
                        int y = tpy + directions[k][1];
                        // x要在[0, row-1]的范围，y要在[0, col-1]的范围，并且该位置必须是“岛”，满足这些添加才添加到queue中
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            queue.add(x * col + y);
                        }
                    }
                }
            }
        }
        // 进行了几次 BFS，就说明有几个孤岛
        return res;
    }

    /**
     * DFS
     */
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int row = grid.length, col = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, visited, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    private void helper(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if (grid[x][y] != '1' || visited[x][y]) return;
        visited[x][y] = true;
        helper(grid, visited, x - 1, y);
        helper(grid, visited, x + 1, y);
        helper(grid, visited, x, y - 1);
        helper(grid, visited, x, y + 1);
    }

    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numIslands(new char[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(obj.numIslands(new char[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}));
        System.out.println(obj.numIslandsDFS(new char[][]{{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}}));
        System.out.println(obj.numIslandsDFS(new char[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}}));
    }
}
// http://blog.csdn.net/wzy_1988/article/details/45066879
// http://www.jianshu.com/p/2777d3942ba7
// https://segmentfault.com/a/1190000003753307