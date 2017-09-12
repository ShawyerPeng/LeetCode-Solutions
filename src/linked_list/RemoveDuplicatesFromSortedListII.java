package linked_list;

public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

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

        ListNode res = RemoveDuplicatesFromSortedListII.deleteDuplicates(head);
        ListNode.printList(res);
    }
}
