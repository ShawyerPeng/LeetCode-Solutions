package linked_list;

/**
 * https://leetcode.com/problems/insertion-sort-list
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, prev = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortList obj = new InsertionSortList();
        ListNode head = ListNode.buildListNode(new int[]{4, 5, 8, 3, 0, 6, 2, 1, 9, 7});
        ListNode.printList(head);

        ListNode.printList(obj.insertionSortList(head));
    }
}
