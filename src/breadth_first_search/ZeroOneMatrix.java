package breadth_first_search;

import java.util.*;

/**
 * https://leetcode.com/problems/01-matrix
 * 问题：Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * 思路：
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return null;

        Queue<int[]> queue = new LinkedList<>();
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // 把 0 元素加入队列中，以备波及影响周围元素
                    queue.offer(new int[]{i, j});
                } else if (matrix[i][j] == 1) {
                    // 设为最大值，方便求 0 元素影响值
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // 上下左右
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // 如果 matrix[x][y] 比 matrix[cur[0]][cur[1]] 小，那说明之前已经更新过，不是 max
                    if (x < 0 || x >= rows || y < 0 || y >= cols || matrix[x][y] <= matrix[cur[0]][cur[1]]) continue;
                    matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        ZeroOneMatrix obj = new ZeroOneMatrix();
        int[][] first = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] second = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result1 = obj.updateMatrix(first);
        int[][] result2 = obj.updateMatrix(second);
        for (int i = 0; i < result1.length; i++) {
            for (int j = 0; j < result1[0].length; j++) {
                System.out.print(result1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[0].length; j++) {
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
// http://blog.csdn.net/mine_song/article/details/70194868
// http://www.cnblogs.com/grandyang/p/6602288.html