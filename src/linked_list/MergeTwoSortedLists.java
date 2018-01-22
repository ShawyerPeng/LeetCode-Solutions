package linked_list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * 问题：
 * 思路：
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        // 在链表头构造一个空节点，这样是有利于链表操作中需要改动链表头时不需要分情况讨论
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = l1;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode next = l2.next;
                l2.next = pre.next;
                pre.next = l2;
                l2 = next;
            } else {
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummy.next;
    }

    /**
     * 在每一次的 Merge 的处理时，只需要考虑 merge 一个元素，也就是提取出一个元素，而下一步的 merge，交给下一步的 recursion来处理。
     */
    public ListNode mergeSortedListRec(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode headMerge = null;
        if (l1.val < l2.val) {
            headMerge = l1;
            l1.next = mergeSortedListRec(l1.next, l2);
        } else {
            headMerge = l2;
            l2.next = mergeSortedListRec(l1, l2.next);
        }
        return headMerge;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode.printList(obj.mergeTwoLists(l1, l2));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/19712593