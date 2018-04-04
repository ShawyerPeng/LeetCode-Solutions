package linked_list;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            // 当return null，说明反转操作已经完成了（不用reverse）
            prev = reverse(prev, k);
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode prev, int k) {
        ListNode last = prev;
        // last指针往后移动k+1步，也就是位于反转区间后一个位置
        for (int i = 0; i < k + 1; i++) {
            last = last.next;
            // last为null了，反转区间还如果不够k个元素，就返回null
            if (i != k && last == null) return null;
        }
        // 指向反转区间首元素，也就是逆转后的尾元素
        ListNode tail = prev.next;
        // 跨过首元素，从第二个开始进行链表头插，也就是把cur提到tail的前面
        ListNode cur = prev.next.next;
        // 当cur移到last，说明要反转的区间已操作完毕
        while (cur != last) {
            // 暂存next指针
            ListNode next = cur.next;
            // 2->3 变成 2->1
            cur.next = prev.next;
            // dummy->1 变成 dummy->2
            prev.next = cur;
            // 1->2 变成 1->3
            tail.next = next;
            // 接着cur后移，以处理下一个节点
            cur = next;
        }
        // tail将会是下一个子序列的prev
        return tail;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        ListNode head = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode.printList(obj.reverseKGroup(head, 2));
        //ListNode.printList(obj.reverseKGroup(head, 3));
    }
}
