package linked_list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 前驱指针prev初始化为空
        ListNode prev = null;
        ListNode cur = head;
        // 访问某个节点cur.next时，要检验cur是否为null
        while (cur != null) {
            ListNode next = cur.next;   // next保存着原来cur.next的地址
            cur.next = prev;            // 使cur指向prev，实现反转，这样就与后面的链表断开了
            prev = cur;                 // prev指针往后移，把保存前一个节点的引用指向当前节点
            cur = next;                 // cur指针往后移，将当前节点指向下一个节点
        }
        // 当cur为null时，prev即为链表尾节点，直接返回作为新反转链表的头
        return prev;
    }

    /**
     * dummy node 头插法
     * 构建一个新的链表头，然后遍历时直接将链表元素加入到新链接中
     */
    public ListNode reverseListDummy(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    /**
     * 全反转
     * 对于反转全部链表 pre就是dummy节点或者null, tail也是null
     * 方法就是设立一个pre前驱节点, 然后有pre的下一个为p1, 再下一个为p2, 以及结尾节点tail.
     * 把p2不停的往pre后面插直到p2=tail为止, 这样就完成了链表的反转
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = cur.next;
        }
        return dummy.next;
    }

    /**
     * 部分反转
     */
    public void reverse(ListNode pre, ListNode last) {
        ListNode cur = pre.next;
        ListNode next = cur.next;
        while (next != last) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        ListNode head = ListNode.getSingleList();
        ListNode.printList(head);
        ListNode.printList(obj.reverseList(head));
        head = ListNode.buildListNode(new int[]{1, 2});
        ListNode.printList(head);
        ListNode.printList(obj.reverseList(head));
    }
}
