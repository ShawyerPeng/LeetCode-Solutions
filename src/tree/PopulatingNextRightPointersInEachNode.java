package tree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            // 1的left是2，1的right是3，所以2要指向3
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            // 2的right是5，2的next的left是3，所以5要指向6
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode start = root;
        // start类似于层序遍历中的每层的最左节点
        while (start != null) {
            TreeLinkNode cur = start;
            // cur类似于层序遍历中的一层中的各个节点
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode obj = new PopulatingNextRightPointersInEachNode();
    }
}
