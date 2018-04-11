package tree;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        // head类似于层序遍历中每层的最左节点
        TreeLinkNode head = null;
        // prev是当前节点的前驱节点
        TreeLinkNode prev = null;
        // cur类似于层序遍历中的一层中的各个节点
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            prev = null;
            head = null;
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII obj = new PopulatingNextRightPointersInEachNodeII();
    }
}
