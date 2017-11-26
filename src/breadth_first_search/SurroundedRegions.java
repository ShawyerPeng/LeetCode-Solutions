package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/surrounded-regions
 * 问题：将所有以'O'组成、但不连通到网格边缘的区域变为'X'
 * 思路：先在四边上寻找连通到边缘的区域，将它们的 O 都变成 Y。剩余的所有 O 一定无法连通到边缘，所以可以全部变为 X。最后再将所有 Y 变回 O。
 * 两点：
 * 1、从边缘入手，因为和边缘上的‘O’相连的‘O’都不会变，所以找出所有这样的‘O’，剩下的‘O’就是被完全包围的，把它们全部变为‘X’。
 * 2、DFS 过程中，暂时把遍历过的‘O'用另外一个符号’#‘代替，最后把被包围的’O‘变成’X'后，在把‘#’恢复成‘O’。
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int row = board.length, col = board[0].length;
        if (row < 3 || col < 3) return;

        Queue<Integer> queue = new LinkedList<>();

        // traverse first column and last column
        for (int i = 0; i < row; i++) {
            helper(i, 0, board, queue);
            helper(i, col - 1, board, queue);
        }
        // traverse first row and last row
        for (int j = 0; j < col; j++) {
            helper(0, j, board, queue);
            helper(row - 1, j, board, queue);
        }

        // change 'O' to 'X', restore '#' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }

        /**
         * 非代码部分，用于测试输出
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void helper(int i, int j, char[][] board, Queue<Integer> queue) {
        int row = board.length, col = board[0].length;
        fill(i, j, board, queue);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / col;
            int y = pos % col;

            fill(x - 1, y, board, queue);
            fill(x + 1, y, board, queue);
            fill(x, y - 1, board, queue);
            fill(x, y + 1, board, queue);
        }
    }

    public void fill(int i, int j, char[][] board, Queue<Integer> queue) {
        int row = board.length, col = board[0].length;
        if (i < 0 || j < 0 || i > row - 1 || j > col - 1) return;
        if (board[i][j] != 'O') return;
        // 把 [i, j] 转化为 i * col + j 存储到 Queue<Integer> 里
        queue.offer(i * col + j);
        board[i][j] = '#';
    }

    public static void main(String[] args) {
        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
// http://blog.csdn.net/ljiabin/article/details/41345055
// http://www.cnblogs.com/yuzhangcmu/p/4132093.html
// http://fisherlei.blogspot.com.br/2013/03/leetcode-surrounded-regions-solution.html