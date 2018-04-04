package linked_list;

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 * 问题：Remove all elements from a linked list of integers that have value val.
 * 思路：单链表每个结点只能引用下一个结点，因此删除结点时，也只能立足于一个不需要被删除的结点，去判断是否需要删除下一个结点。
 * 由于删除时候需要遍历链表，但遍历的开始必须是头结点，而头结点如果要删除就要额外处理了。这里我们在头结点之前再插入一个临时结点，以统一处理整个链表。
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNode.printList(head);
        RemoveLinkedListElements obj = new RemoveLinkedListElements();
        ListNode res = obj.removeElements(head, 6);
        ListNode.printList(res);
    }
}
// https://wjqwsp.github.io/2016/09/24/LeetCode-203-Remove-Linked-List-Elements-题解