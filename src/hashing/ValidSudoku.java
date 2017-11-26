//package hashing;
//
///**
// * https://leetcode.com/problems/valid-sudoku
// * 问题：数独游戏。规则：9*9 网格的每一行、每一列、每个小九宫格(9个)都不能有重复的数字
// * 思路：利用 HashSet 的唯一性来帮助 check。
// * 先检查行列，再检查小9格。
// */
//public class ValidSudoku {
//    public static boolean isValidSudoku(char[][] board) {
//        if (board == null || board.length != 9 || board[0].length != 9) return false;
//        boolean[][] row = new boolean[9][9];
//        boolean[][] col = new boolean[9][9];
//        boolean[][] matrix = new boolean[9][9];
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] == '.') continue;
//                int n = board[i][j] - '1';
//                if (row[i][n] || col[j][n] || matrix[i - i % 3 + j / 3][n]) {
//                    return false;
//                }
//                row[i][n] = col[j][n] = matrix[i - i % 3 + j / 3][n] = true;
//
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//// http://www.cnblogs.com/springfor/p/3884217.html
//// http://www.cnblogs.com/TenosDoIt/p/3800485.html
