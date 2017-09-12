package linked_list;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

        if (cn != 0) {
            p.next = new ListNode(cn);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildListNode(new int[]{2, 4, 3});
        ListNode l2 = ListNode.buildListNode(new int[]{5, 6, 4});
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode res = AddTwoNumbers.addTwoNumbers(l1, l2);
        ListNode.printList(res);
    }
}
// 参考：https://siddontang.gitbooks.io/leetcode-solution/content/linked_list/add_two_numbers.html