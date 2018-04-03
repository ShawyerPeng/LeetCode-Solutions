package linked_list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 * 问题：Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 思路：
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                // 直接删除掉后面那个重复的节点，并且cur不变
                cur.next = cur.next.next;
            } else {
                // 只有当比较的两个元素不同，cur才移动到下一个节点
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1, 1, 2, 3, 3});
        ListNode.printList(head);
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        ListNode res = obj.deleteDuplicates(head);
        ListNode.printList(res);
    }
}
