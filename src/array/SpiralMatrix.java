package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return results;
        int row = matrix.length, col = matrix[0].length;
        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                results.add(matrix[rowBegin][i]);
            }
            // 开始下一行
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                results.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // 行数不变，列数变动
                for (int i = colEnd; i >= colBegin; i--) {
                    results.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    results.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return results;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        System.out.println(obj.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
// https://soulmachine.gitbooks.io/algorithm-essentials/content/java/simulation/spiral-matrix.html