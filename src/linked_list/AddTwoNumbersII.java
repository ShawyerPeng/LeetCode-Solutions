package linked_list;

import java.util.Stack;

/**
 * https://leetcode.com/problems/add-two-numbers-ii
 * 问题：两个链表 l1 和 l2，返回一个链表，其值为 l1 与 l2 的和。
 * 思路：先分别对每个 number 链表进行反转，然后进行相加，最后将所得链表再进行反转。
 * 将 l1 和 l2 分别放入栈s1 s2中，这样他们就被倒置了，然后依次出栈将结果相加，（不要忘记考虑进位问题），
 * 结果放入新的栈 s 中，然后将 s 弹栈，结果放入一个新链表中。
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int cn = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int val = cn;
            if (!s1.isEmpty()) {
                val += s1.pop();
            }
            if (!s2.isEmpty()) {
                val += s2.pop();
            }
            // 产生进位cn
            cn = val / 10;
            val = val % 10;
            stack.push(val);
        }

        // 当l1、l2都到达链表尾且有进位时
        if (cn != 0) stack.push(cn);

        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersII obj = new AddTwoNumbersII();
        ListNode l1 = ListNode.buildListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode res = obj.addTwoNumbers(l1, l2);
        ListNode.printList(res);

        l1 = ListNode.buildListNode(new int[]{5});
        l2 = ListNode.buildListNode(new int[]{5});
        res = obj.addTwoNumbers(l1, l2);
        ListNode.printList(res);
    }
}
// https://www.liuchuo.net/archives/3100