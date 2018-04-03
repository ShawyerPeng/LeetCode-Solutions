package linked_list;

import template.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        return build(head, null);
    }

    private TreeNode build(ListNode start, ListNode end) {
        if (start == end) return null;

        ListNode fast = start;
        ListNode slow = start;
        // fast走到结尾，那么slow就是中间节点了，即BST的根节点
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 递归处理相应的左右部分，链表的左半部分就是左子树，而右半部分则是右子树
        TreeNode node = new TreeNode(slow.val);
        node.left = build(start, slow);
        node.right = build(slow.next, end);

        return node;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
        ListNode head = ListNode.buildListNode(new int[]{-10, -3, 0, 5, 9});
        obj.sortedListToBST(head);
    }
}
