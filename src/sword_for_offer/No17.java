package sword_for_offer;

import linked_list.ListNode;

/**
 * https://www.nowcoder.com/questionTerminal/d8b6b4358f774294a89de2a6ac4d9337
 * 问题：合并两个排序的链表
 * 思路：
 */
public class No17 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        // 新建一个头节点，用来存合并的链表
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode head = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }

        // 把未结束的链表连接到合并后的链表尾部
        if (list1 != null) head.next = list1;
        if (list2 != null) head.next = list2;
        return dummy.next;
    }

    public ListNode MergeRec(ListNode list1, ListNode list2) {
        // 递归的出口是一个其中链表为空
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        // 新建一个头节点，用来存合并的链表
        ListNode head = null;
        // 每次比较两个链表的头节点，小的那个拿出来放到新链表中，这样递归
        if (list1.val < list2.val) {
            head = list1;
            head.next = MergeRec(list1.next, list2);
        } else {
            head = list2;
            head.next = MergeRec(list1, list2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        No17 obj = new No17();
        ListNode list1 = ListNode.buildListNode(new int[]{1, 2, 4, 5, 7});
        ListNode list2 = ListNode.buildListNode(new int[]{1, 3, 4, 6, 8});
        ListNode.printList(obj.Merge(list1, list2));
    }
}
