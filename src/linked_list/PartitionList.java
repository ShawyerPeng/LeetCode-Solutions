package linked_list;

/**
 * https://leetcode.com/problems/partition-list/
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode smallerHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode smaller = smallerHead;
        ListNode greater = greaterHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                smaller.next = temp;
                smaller = smaller.next;
            } else {
                greater.next = temp;
                greater = greater.next;
            }
            head = head.next;
        }
        smaller.next = greaterHead.next;
        return smallerHead.next;
    }

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();
        ListNode head = ListNode.buildListNode(new int[]{1, 4, 3, 2, 5, 2});
        ListNode.printList(obj.partition(head, 3));
    }
}
