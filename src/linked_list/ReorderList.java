package linked_list;

import java.util.List;

/**
 * https://leetcode.com/problems/reorder-list
 * 问题：
 * 思路：
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = null;
        ListNode slow = head, fast = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 截断后半部分
        temp.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        while (l1 != l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }

    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        obj.reorderList(head);
        ListNode.printList(head);
    }
}
