package breadth_first_search;

import java.util.*;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow
 * 问题：水只能由高往低处流动，问从Pacific到Atlantic两者间怎么流动
 * 思路：
 */
public class PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return results;

        int row = matrix.length, col = matrix[0].length;
        // 初始化visited数组，初始化为 false，表示所有的点均没有访问过
        boolean[][] pVisited = new boolean[row][col];
        boolean[][] aVisited = new boolean[row][col];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 把垂直边界上的点分别存入 queue 中，然后对应的 visited 状态标记为 true
        for (int i = 0; i < row; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, col - 1});
            pVisited[i][0] = true;
            aVisited[i][col - 1] = true;
        }
        // 把水平边界上的点分别存入 queue 中，然后对应的 visited 状态标记为 true
        for (int i = 0; i < col; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{row - 1, i});
            pVisited[0][i] = true;
            aVisited[row - 1][i] = true;
        }
        // 分别开始 BFS 遍历
        bfs(matrix, pQueue, pVisited);
        bfs(matrix, aQueue, aVisited);
        // 遍历结束后还是找 pacific 和 atlantic 均标记为 true 的点加入 res 中返回即可
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pVisited[i][j] && aVisited[i][j])
                    results.add(new int[]{i, j});
            }
        }

        return results;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : directions) {
                // row = cur[0], col = cur[1], k=1,2,3,4这四个方向
                // 用 (row + dir[k][0], col + dir[k][1]) 表示延展的点，代码可以干净很多
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) continue;

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        List<int[]> results = obj.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }
}
// http://blog.csdn.net/a1025461748/article/details/74911006
// http://www.cnblogs.com/grandyang/p/5962508.html
// http://blog.csdn.net/magicbean2/article/details/78319176
// http://bgmeow.xyz/2017/01/28/LeetCode-417/