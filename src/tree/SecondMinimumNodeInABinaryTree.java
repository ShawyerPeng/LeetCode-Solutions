//package tree;
//
//import template.TreeNode;
//
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.TreeSet;
//
///**
// * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree
// * 问题：求二叉树中第二大的数字
// * 思路：层序遍历，不停地更新 second 的值
// */
//public class SecondMinimumNodeInABinaryTree {
//    public int findSecondMinimumValue(TreeNode root) {
//        int first = root.val, second = Integer.MAX_VALUE;
//        HashSet<Integer> set = new HashSet();
//        Queue<TreeNode> queue = new LinkedList<>();
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node.val != first && node.val < second) {
//                second = node.val;
//            }
//            set.add(node.val);
//            if (node.left != null) queue.offer(node.left);
//            if (node.right != null) queue.offer(node.right);
//        }
//        //return (second == first || second == Integer.MAX_VALUE) ? -1 : second;
//        int[] res = set.toArray();
//        return ;
//    }
//
//    public static void main(String[] args) {
//        SecondMinimumNodeInABinaryTree obj = new SecondMinimumNodeInABinaryTree();
//        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
//        System.out.println(obj.findSecondMinimumValue(root));
//    }
//}
//// http://www.cnblogs.com/grandyang/p/7590156.html