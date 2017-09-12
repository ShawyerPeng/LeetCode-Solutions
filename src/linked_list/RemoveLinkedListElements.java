package linked_list;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSingleList();
        ListNode.printList(head);
        ListNode res = RemoveLinkedListElements.removeElements(head, 3);
        ListNode.printList(res);
    }
}
