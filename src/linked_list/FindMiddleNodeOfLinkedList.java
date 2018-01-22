package linked_list;

/**
 *
 */
public class FindMiddleNodeOfLinkedList {
    public ListNode findMiddleNodeOfLinedList(ListNode head) {
        // 判断空链表、单节点链表  
        if (null == head || null == head.next) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        while (null != p2.next && null != p2.next.next) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        FindMiddleNodeOfLinkedList obj = new FindMiddleNodeOfLinkedList();
        ListNode.printList(obj.findMiddleNodeOfLinedList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
// http://blog.csdn.net/wkupaochuan/article/details/8663335