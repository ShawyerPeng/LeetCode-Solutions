package binary_search;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;
        // i指向最后一行，j指向第一列
        int i = row - 1;
        int j = 0;
        int count = 0;
        // from bottom left to top right
        while (i >= 0 && j < col) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII obj = new SearchA2DMatrixII();
        System.out.println(obj.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
    }
}