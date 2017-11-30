package tree;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-two-binary-trees
 * 问题：合并两个二叉树，如果在同一位置两个节点都存在，则两个数相加。否则，将当前对应的非空结点作为当前结点。
 * 思路：遇到树的问题，首先想到的就是能不能用递归。
 * 如果其中一棵树为 null，则直接返回另外一棵树
 * 如果都是非 null 的二叉树，则将该结点的值更新为两者值之和，并向下递归，合并两者的左右结点
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode result = new TreeNode(t1.val + t2.val);
        dfs(t1, t2, result);
        return result;
    }

    private void dfs(TreeNode t1, TreeNode t2, TreeNode result) {
        if (t1 == null && t2 == null) return;
        else if (t1 != null && t2 == null) {
            result.val = t1.val;
            //result = new TreeNode(t1.val);
            dfs(t1.left, null, result.left);
            dfs(t1.right, null, result.right);
        } else if (t1 == null && t2 != null) {
            result.val = t2.val;
            //result = new TreeNode(t2.val);
            dfs(null, t2.left, result.left);
            dfs(null, t2.right, result.right);
        } else {
            result.val = t1.val + t2.val;
            //result = new TreeNode(t1.val + t2.val);
            dfs(t1.left, t2.left, result.left);
            dfs(t1.right, t2.right, result.right);
        }
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees2(t1.left, t2.left);
            root.right = mergeTrees2(t1.right, t2.right);
            return root;
        } else {
            return t1 != null ? t1 : t2;
        }
    }

    public TreeNode mergeTreesStack(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // stack 里存放 t1 与 t2 组成的 array
        Stack<TreeNode[]> stack = new Stack<>();
        // push 首节点
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] cur = stack.pop();
            // t2为null
            if (cur[1] == null) continue;

            cur[0].val += cur[1].val;
            // 如果 t1 的 child 为 null 就直接把 t2 对应的 child 赋值到 t1 上
            // 如果 t1 的 child 不为 null 时就把 t1 与 t2 对应的 child 放进 stack
            if (cur[0].left == null) {
                cur[0].left = cur[1].left;
            } else {
                stack.push(new TreeNode[]{cur[0].left, cur[1].left});
            }

            if (cur[0].right == null) {
                cur[0].right = cur[1].right;
            } else {
                stack.push(new TreeNode[]{cur[0].right, cur[1].right});
            }
        }
        // 归值到 t1 上
        return t1;
    }

    public TreeNode mergeTreesBFS(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(t1);
        queue2.offer(t2);
        // Using t1 as the resulting Binary Tree
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode curr1 = queue1.poll();
            TreeNode curr2 = queue2.poll();
            TreeNode result = curr1;
            result.val = curr1.val + curr2.val;

            if (curr1.left == null || curr2.left == null) {
                result.left = curr1.left == null ? curr2.left : curr1.left;
            } else if (curr1.left != null && curr2.left != null) {
                queue1.offer(curr1.left);
                queue2.offer(curr2.left);
            }

            if (curr1.right == null || curr2.right == null) {
                result.right = curr1.right == null ? curr2.right : curr1.right;
            } else if (curr1.right != null && curr2.right != null) {
                queue1.offer(curr1.right);
                queue2.offer(curr2.right);
            }
        }

        return t1;
    }

    public static void main(String[] args) {
        MergeTwoBinaryTrees obj = new MergeTwoBinaryTrees();
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        //System.out.println(obj.mergeTrees2(t1, t2).left.left.val);
        System.out.println(obj.mergeTreesBFS(t1, t2).left.left.val);
        System.out.println(obj.mergeTreesStack(t1, t2).left.left.val);
    }
}
// http://blog.csdn.net/Yaokai_AssultMaster/article/details/73411811
// http://www.voidcn.com/article/p-vfkcrzzf-wa.html
// http://www.cnblogs.com/Dylan-Java-NYC/p/7381181.html