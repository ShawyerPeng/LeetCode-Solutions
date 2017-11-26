//package breadth_first_search;
//
//import template.TreeNode;
//
//import java.util.*;
//
///**
// * https://leetcode.com/problems/minesweeper
// */
//public class Minesweeper {
//    public char[][] updateBoard(char[][] board, int[] click) {
//        List<List<Integer>> results = new ArrayList<>();
//        if (board == null) return null;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; ++i) {
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//            }
//            // 每次将level添加到0索引处，这样就是bottom-up顺序保存的
//            results.add(0, level);
//        }
//
//        return results;
//    }
//
//    public static void main(String[] args) {
//        Minesweeper obj = new Minesweeper();
//        System.out.println(Arrays.toString(
//                obj.updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3,0})));
//    }
//}
//// https://medium.com/@william456821/leetcode-529-minesweeper-%E8%B8%A9%E5%9C%B0%E9%9B%B7-bfs-dfs-451425e55508