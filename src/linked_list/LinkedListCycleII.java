package linked_list;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果相遇了
            if (fast == slow) {
                // 从头有个指针开始走了
                ListNode slow2 = head;
                // 两个指针相遇时也就刚好到达了环的第一个节点，参照博客分析
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleII obj = new LinkedListCycleII();
    }
}
