package sword_for_offer;

import linked_list.ListNode;

/**
 * 问题：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * 思路：要三个指针，分别指向当前遍历到的结点。它的前一个结点和后一个结点。
 */
public class No16 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 逆置后的头结点
        ListNode reversedHead = null;
        ListNode prev = null;
        // 当前头结点
        ListNode cur = head;
        while (cur != null) {
            // 保存后继
            ListNode next = cur.next;

            // next为null的节点为尾节点（翻转后的头结点一定是原始链表的尾结点）
            if (next == null) reversedHead = cur;

            // 逆转的过程，并且能将头结点的 prev 置为 NULL
            cur.next = prev;

            // 指针往后移
            prev = cur; // 前继结点到现任节点，勿忘断链的情形，需要使用 pre 指针保存状态，pre 等价于是后移一个结点
            cur = next; // 现任节点到下一结点，cur 后移一个结点
        }
        return reversedHead;
    }

    public static void main(String[] args) {
        No16 obj = new No16();
        ListNode.printList(obj.ReverseList(ListNode.buildListNode(new int[]{1, 2, 3, 4, 5})));
        ListNode.printList(obj.ReverseList(ListNode.buildListNode(new int[]{1})));
        ListNode.printList(obj.ReverseList(ListNode.buildListNode(new int[]{})));
    }
}
