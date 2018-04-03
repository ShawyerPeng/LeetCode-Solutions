package linked_list;

/**
 * https://leetcode.com/problems/linked-list-cycle
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // fast如果和slow相遇了，证明有环
            if (slow == fast) return true;
        }
        // fast如果走到了null，证明没有环
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle obj = new LinkedListCycle();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4});
        System.out.println(obj.hasCycle(head));
    }
}