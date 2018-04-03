package linked_list;

/**
 * https://leetcode.com/problems/odd-even-linked-list
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        // 因为odd肯定在even之前，所以只需要判断even和even.next不为空就可以﻿
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        // 奇数的结尾指向偶数的头
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList obj = new OddEvenLinkedList();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(obj.oddEvenList(head));
    }
}
