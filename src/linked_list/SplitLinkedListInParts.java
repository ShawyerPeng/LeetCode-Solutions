package linked_list;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-linked-list-in-parts
 * 问题：
 * 思路：
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];

        int len = 0;
        for (ListNode cur = root; cur != null; cur = cur.next) len++;

        int part = len / k;
        int surplus = len % k;
        ListNode head = root;
        ListNode prev = null;
        for (int i = 0; i < k; i++, surplus--) {
            res[i] = head;
            // 多的部分有k+1个，少的部分有k个
            for (int j = 0; j < part + (surplus > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            // 与后面部分断开
            if (prev != null) prev.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts obj = new SplitLinkedListInParts();
        ListNode root = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode[] res = obj.splitListToParts(root, 3);
        for (ListNode head : res) {
            ListNode.printList(head);
        }
    }
}