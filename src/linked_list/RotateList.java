package linked_list;

/**
 * https://leetcode.com/problems/rotate-list
 * 问题：Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode index = head;
        int len = 1;
        // 得到链表长度
        while (index.next != null) {
            index = index.next;
            len++;
        }
        // 因为k可能大于链表长度len，所以需要取余处理
        k %= len;

        // 链表首尾连成一个环
        index.next = head;
        // 得到新的链表头
        for (int i = 1; i < len - k; i++) {
            head = head.next;
        }
        // res是新的head
        ListNode res = head.next;
        // 断开环
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        RotateList obj = new RotateList();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(obj.rotateRight(head, 2));
    }
}
