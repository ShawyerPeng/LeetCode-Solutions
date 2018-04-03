package sword_for_offer;

import linked_list.ListNode;

/**
 * https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a
 * 问题：链表中倒数第 k 个结点。
 * 思路：
 * 一般思路是：先走到链表的尾端，再回溯 k 步，但由于是单向链表，该思路行不通。
 * 另一个思路是，假设链表有 n 个结点，倒数第 k 个，就是从头开始第 n-k+1 个结点，这个不难，遍历链表第一次得到结点个数 n，遍历第二次得到第 n-k+1 个结点。
 * 更好的思路是：只遍历链表一次就能找到倒数第 k 个结点，我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走 k-1，第二个指针不动；
 * 从第 k 步开始，第二个指针也开始从链表头指针开始遍历。由于两个指针的距离保持在 k-1，当第一个指针到达链表的尾结点时，第二个指针正好是倒数第 k 个结点。
 */
public class No15 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k - 1; i++) {
            // 链表节点数可能小于k
            if (fast.next != null)
                // 快指针先走k-1步
                fast = fast.next;
            else
                return null;
        }

        // 快指针走到尾节点就退出循环
        while (fast.next != null) {
            // 从第k步开始，两个指针一起走
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        No15 obj = new No15();
        System.out.println(obj.FindKthToTail(ListNode.buildListNode(new int[]{1, 2, 3, 4, 5}), 2).val);
    }
}
// http://blog.csdn.net/abc7845129630/article/details/52724583