package linked_list;

/**
 * https://leetcode.com/problems/palindrome-linked-list
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 找中点
        ListNode mid = findMiddle(head);
        // 对中点后的节点进行反转
        mid.next = reverse(mid.next);

        // 分别对两部分[head,mid)和[mid.next,null)的值一一进行比较
        ListNode p = head;
        ListNode q = mid.next;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 4, 5, 4, 2, 1});
        System.out.println(obj.isPalindrome(head));
    }
}
