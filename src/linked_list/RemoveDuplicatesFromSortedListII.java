package linked_list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * 问题：Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 思路：
 * 分析：time:O(n)，因为只需要遍历一遍
 * space:O(1)
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int duplicate = head.next.val;
                while (head.next != null && head.next.val == duplicate) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1,1});
        ListNode.printList(head);
        RemoveDuplicatesFromSortedListII obj = new RemoveDuplicatesFromSortedListII();
        ListNode res = obj.deleteDuplicates(head);
        ListNode.printList(res);
    }
}
