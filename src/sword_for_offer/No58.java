package sword_for_offer;

/**
 * 问题：二叉树的下一个结点。给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 思路：
 */
public class No58 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode parent = null;
        TreeLinkNode left = null;
        TreeLinkNode right = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) return null;

        // 保存要查找的下一个节点
        TreeLinkNode target = null;

        // 如果有右子树
        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }
            return target;
        } else if (node.parent != null) {
            // 如果没有右子树，并且子结点是父结点的左孩子
            target = node.parent;
            // 如果父新结点不为空，并且子结点不是父结点的左孩子
            TreeLinkNode cur = node;
            while (target != null && target.left != cur) {
                cur = target;
                target = target.parent;

            }
            return target;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
// http://blog.csdn.net/derrantcm/article/details/46847919
// http://blog.csdn.net/wuxiaosi808/article/details/76974237