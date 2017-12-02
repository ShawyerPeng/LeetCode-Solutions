package sword_for_offer;

import linked_list.ListNode;

/**
 * 问题：在O(1)时间删除链表节点
 * 思路：
 */
public class No13 {
    public void deleteNode(ListNode head, ListNode delete) {
        if (head == null || delete == null) return;

        // 链表有多个节点，要删除的结点不是尾结点: O(1) 时间
        if (delete.next != null) {
            ListNode next = delete.next;
            delete.val = next.val;
            delete.next = next.next;
            next = null;
        } else if (head == delete) {
            // 链表只有一个结点，删除头结点（也是尾结点）:O(1) 时间
            delete = null;
            head = null;
        } else {
            // 链表有多个节点，要删除的是尾节点: O(n) 时间
            ListNode temp = head;
            while (temp.next != delete) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static void main(String[] args) {
        No13 obj = new No13();
        obj.deleteNode(new ListNode(1, new ListNode(2, new ListNode(3))), new ListNode(2));
        System.out.println();
    }
}
// http://www.tk4479.net/abc7845129630/article/details/52701451