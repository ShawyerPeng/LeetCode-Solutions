package linked_list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list
 * 问题：对于一个给定的指针链表，删除其倒数第 N 个元素。
 * 思路：双指针。一个指针先走 n 步，然后两个同步走，直到第一个走到终点，第二个指针就是需要删除的节点。
 * 注意：1. 保留慢指针的前置指针，这样才能删除。
 * 2. 特殊处理需要删除头指针的情况，如输入 1->2->3->4; n=4，那么需要删除 1，这就需要特殊处理了，头指针往前一步就可以了。
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 使用dummy node，方便删除链首元素
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return null;

        // 设立头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化slow,fast
        ListNode slow = dummy, fast = dummy;

        // fast指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 两个指针同时移动直到p2到达最后
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除并返回
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n <= 0) return null;

        // 设立头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 初始化slow,fast
        ListNode slow = head, fast = head;

        // fast指针先走n步
        //while (--n> 0) fast = fast.next;
        for (int i = 0; i < n; i++) fast = fast.next;
        // 注意对删除头结点的单独处理，要删除头结点时，没办法帮他维护 prev 节点，所以当发现要删除的是头结点时，直接让 head = head.next 并 return head
        if (fast == null) {
            head = head.next;
            return head;
        }
        // 两个指针同时移动直到p2到达最后
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 删除并返回
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        ListNode.printList(obj.removeNthFromEnd(ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}), 2));
        ListNode.printList(obj.removeNthFromEnd(ListNode.buildListNode(new int[]{1}), 1));
    }
}
// http://blog.csdn.net/kenden23/article/details/16980197