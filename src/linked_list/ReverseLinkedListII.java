package linked_list;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public ListNode reverseListBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        // 找反转区间头节点的前驱，即1->2->3->4->5->NULL中的1，循环过后prev指向1、cur指向2
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        // cur此时是反转区间的头节点
        ListNode cur = prev.next;
        // 在指定区间内不断进行反转
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;       // 越过cur.next，指向cur.next.next，即本来2->3，现在变成了2->4
            temp.next = prev.next;      // temp指向prev.next，即本来3->4，现在变成了3->2
            prev.next = temp;           // 即本来1->2，现在变成了1->3
            // 经过以上步骤变成了1->3->2->4->5
            // 再经过一次最后变成了1->4->3->2->5
        }
        //for (int i = 0; i < n - m; i++) {
        //    ListNode temp = cur.next;
        //    dummy.next = cur;
        //    cur.next = dummy.next;
        //    cur = temp;
        //}
        return dummy.next;
    }

    public ListNode reverseListBetween2(ListNode head, int m, int n) {
        if (m > n || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }

        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = mNode.next;

        for (int i = m; i < n; i++) {
            ListNode tem = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = tem;
        }
        preM.next = nNode;
        mNode.next = postN;

        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII obj = new ReverseLinkedListII();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(head);
        ListNode.printList(obj.reverseListBetween(head, 2, 4));
    }
}
// 参考：http://ryanleetcode.blogspot.jp/2015/06/blog-post.html?m=1