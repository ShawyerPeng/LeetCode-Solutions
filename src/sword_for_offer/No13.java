package sword_for_offer;

import linked_list.ListNode;

/**
 *
 * 问题：在O(1)时间删除链表节点
 * 思路：
 */
public class No13 {
    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) return;

        // 链表有多个节点，要删除的结点不是尾结点: O(1) 时间
        if (toBeDeleted.next != null) {
            ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
            next = null;
        } else if (head == toBeDeleted) {
            // 链表只有一个结点，删除头结点（也是尾结点）:O(1) 时间
            toBeDeleted = null;
            head = null;
        } else {
            // 链表有多个节点，要删除的是尾节点: O(n) 时间
            ListNode temp = head;
            while (temp.next != toBeDeleted) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        No13 obj = new No13();
        ListNode toBeDeleted = new ListNode(2, new ListNode(3));
        ListNode head = new ListNode(1, toBeDeleted);
        ListNode.printList(head);
        obj.deleteNode(head, toBeDeleted);
        ListNode.printList(head);
    }
}
// http://www.tk4479.net/abc7845129630/article/details/52701451