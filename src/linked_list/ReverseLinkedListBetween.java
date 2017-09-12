package linked_list;

public class ReverseLinkedListBetween {
    public static ListNode reverseListBetween(ListNode head, int m, int n) {
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
        ListNode head = ListNode.getSingleList();
        ListNode.printList(head);
        ListNode res = ReverseLinkedListBetween.reverseListBetween(head, 1, 2);
        ListNode.printList(res);
    }
}
// 参考：http://ryanleetcode.blogspot.jp/2015/06/blog-post.html?m=1