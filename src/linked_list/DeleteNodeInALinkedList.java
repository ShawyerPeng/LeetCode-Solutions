package linked_list;

public class DeleteNodeInALinkedList {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSingleList();
        ListNode.printList(head);
        DeleteNodeInALinkedList.deleteNode(head);
        ListNode.printList(head);
    }
}
