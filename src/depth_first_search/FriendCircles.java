package depth_first_search;

/**
 * https://leetcode.com/problems/friend-circles
 * 问题：求朋友圈的个数，题目中对于朋友圈的定义是可以传递的，比如 A 和 B 是好友，B 和 C 是好友，那么即使 A 和 C 不是好友，那么他们三人也属于一个朋友圈。
 * 思路：
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if (M == null && M.length == 0) return 0;

        int size = M.length;
        boolean[] visited = new boolean[size];
        int count = 0;
        // 如果 dfs 大于 0，说明有未遍历的结点
        // 只需要遍历所有结点
        for (int i = 0; i < size; i++) {
            if (dfs(i, visited, M) > 0) count++;
        }
        return count;
    }

    private int dfs(int index, boolean[] visited, int[][] M) {
        if (visited[index]) return 0;
        // 更新为已访问
        visited[index] = true;
        int count = 1;
        for (int i = 0; i < visited.length; i++) {
            if (i != index && M[index][i] == 1) {
                count += dfs(i, visited, M);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FriendCircles obj = new FriendCircles();
        System.out.println(obj.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
// http://blog.csdn.net/mine_song/article/details/70195463
// http://www.cnblogs.com/grandyang/p/6686983.html