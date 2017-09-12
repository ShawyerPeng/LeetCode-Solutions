package linked_list;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

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

        ListNode res = RemoveDuplicatesFromSortedList.deleteDuplicates(head);
        ListNode.printList(res);
    }
}
