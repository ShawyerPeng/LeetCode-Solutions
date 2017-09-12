package linked_list;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;  // 初始化为空
        // 访问某个节点cur.next时，要检验cur是否为null
        while (head != null) {
            ListNode temp = head.next;  // temp保存着原来head->next的地址
            head.next = prev;           // 使head指向prev，这样就与后面的链表断开了
            prev = head;                // prev指针往后移
            head = temp;                // head指针往后移
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getSingleList();
        ListNode.printList(head);
        ListNode res = ReverseLinkedList.reverseList(head);
        ListNode.printList(res);
    }
}
