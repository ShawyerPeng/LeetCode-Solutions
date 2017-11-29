package backtracking;

/**
 * https://leetcode.com/problems/word-search
 * 问题：
 * 思路：
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return true;
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                // 从(i,j)点作为起点开始搜索
                if (board[i][j] == word.charAt(0) && dfs(0, i, j, board, word)) return true;
        return false;
    }

    private boolean dfs(int index, int i, int j, char[][] board, String word) {
        // 搜索结束的标志是k == word.length()，不是 k == word.length() - 1
        if (index == word.length()) return true;
        int[][] dirs = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;

        char ctmp = board[i][j];
        // 标记为已访问，对于 board 中元素已访问的标志可以设一个访问标志数组，也可以把已访问的元素设置成某个字符
        board[i][j] = '#';
        // 四个方向 dfs
        boolean result = false;
        for (int[] dir : dirs) {
            result = dfs(index + 1, i + dir[0], j + dir[1], board, word);
            if (result) return result;
        }
        //boolean result = dfs(index + 1, i - 1, j, board, word) ||
        //        dfs(index + 1, i + 1, j, board, word) ||
        //        dfs(index + 1, i, j - 1, board, word) ||
        //        dfs(index + 1, i, j + 1, board, word);
        // 恢复原来的字母
        board[i][j] = ctmp;
        return result;
    }

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(obj.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
// http://bangbingsyb.blogspot.com.br/2014/11/leetcode-word-search.html
// http://www.lifeincode.net/programming/leetcode-word-search-java/
// https://www.youtube.com/watch?v=oUeGFKZvoo4