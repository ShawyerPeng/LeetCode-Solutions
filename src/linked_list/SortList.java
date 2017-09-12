package linked_list;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;    // 如果为空或只有一个点，直接return

        ListNode mid = findMiddle(head);        // 找中点
        ListNode right = sortList(mid.next);    // 对mid的右边链表先排序
        mid.next = null;                        // 这时候才把它断开
        ListNode left = sortList(head);         // 再对mid的左边链表排序

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {   // 快慢指针
        ListNode slow = head, fast = head.next;    // 因为不知道新的头是谁，所以要使用dummy node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;     // 尾指针指向dummy node
        while (head1 != null && head2 != null) {    // 两个头是否为空
            if (head1.val < head2.val) {  // 如果左边的头小
                tail.next = head1;     // 把左边头放到tail里
                head1 = head1.next;
            } else {                        // 如果右边的头小
                tail.next = head2;     // 把右边头放到tail里
                head2 = head2.next;
            }
            tail = tail.next;  //tail往后移
        }
        if (head1 != null) {        // 看左边头还是右边头没分完就分过去
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2,4,3,7,0});
        ListNode.printList(l1);

        SortList prob = new SortList();
        ListNode res = prob.sortList(l1);
        ListNode.printList(res);
    }
}
