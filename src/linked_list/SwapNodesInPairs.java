package linked_list;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode next = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = next;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs obj = new SwapNodesInPairs();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        ListNode.printList(obj.swapPairs(head));
    }
}
