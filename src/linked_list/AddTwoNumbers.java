package linked_list;

/**
 * https://leetcode.com/problems/add-two-numbers
 * 问题：有两个包含非负整数的链表，这两个链表也是非空的。数字倒序存储并且它们每个节点包含一个数字。分别对两个链表的每个数字相加，并将结果存在一个链表中返回。
 * 你可以假设两个链表中不包含任何前导零 (leading zero)，数字 0 除外。
 * 思路：对两个链表同时遍历相加，并设置一个标识位cn用来表示是否需要进位。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) cur.next = new ListNode(1);
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int cn = 0;
        while (l1 != null || l2 != null) {
            int val = cn;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            // 产生进位cn
            cn = val / 10;
            val = val % 10;
            p.next = new ListNode(val);
            p = p.next;
        }
        // 当l1、l2都到达链表尾且有进位时
        if (cn != 0) p.next = new ListNode(cn);
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers obj = new AddTwoNumbers();
        ListNode l1 = ListNode.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode.printList(l1);
        ListNode.printList(l2);

        ListNode res = obj.addTwoNumbers(l1, l2);
        ListNode.printList(res);
    }
}
// 参考：https://siddontang.gitbooks.io/leetcode-solution/content/linked_list/add_two_numbers.html