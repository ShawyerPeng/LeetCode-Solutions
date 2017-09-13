package template;

import java.util.ArrayList;

public class Traverse {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    // 把root为跟的preorder加入result里面
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }



    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);

        return result;
    }

    public static void main(String[] args) {

    }
}
