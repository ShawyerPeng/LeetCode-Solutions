package binary_search;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ShawyerPeng on 2018/4/1.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k == count + 1) {
            return root.val;
        } else if (k <= count) {
            return kthSmallest(root.left, k);
        } else {
            // count is the left tree num, 1 is the root
            return kthSmallest(root.right, k - 1 - count);
        }
    }

    private int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> results = new ArrayList<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                // 左孩子依次入栈，访问最左孩子
                stack.push(node);
                node = node.left;
            }
            // 访问根节点
            node = stack.pop();
            results.add(node.val);
            // 把根节点右孩子当做当前节点
            node = node.right;
        }
        return results.get(k - 1);
    }

    public static void main(String[] args) {
        KthSmallestElementInABST obj = new KthSmallestElementInABST();
        TreeNode root = new TreeNode(1);
        System.out.println(obj.kthSmallest(root, 1));
    }
}
