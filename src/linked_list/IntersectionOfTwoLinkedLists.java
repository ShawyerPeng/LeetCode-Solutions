package linked_list;

import java.util.Stack;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 * 问题：链表交点
 * 思路：双指针法：分别遍历两个链表，得到分别对应的长度。然后求长度的差值，把较长的那个链表向后移动这个差值的个数，然后一一比较即可。
 * 因为在交点之前，两个链表的长度不同，如果我们知道他们的长度差，那么只要在长的链表上先前进他们相差的节点数，然后两个指针同时各自在两个链表上前进，
 * 那么当他们相遇的时候就是第一个相交的节点。而那个差就是两个链表的长度差，因为它们的后半部分是相同的。
 * 哈希表法：遍历链表 A，并且将节点存储到哈希表中。接着遍历链表 B，对于 B 中的每个节点，查找哈希表，如果在哈希表中找到了，说明是交集开始的那个节点。
 * 时间复杂度 O(lengthA+lengthB)，空间复杂度 O(lengthA) 或 O(lengthB)。
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA, nodeB = headB;
        int lenA = 0, lenB = 0;
        // 计算链表A的长度
        while (nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }
        // 计算链表B的长度
        while (nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }
        // 让较长的链表先飞一会
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            if (lenA < lenB) headB = headB.next;
            else if (lenA > lenB) headA = headA.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeStack(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        // 保存第一个相交节点
        ListNode common = null;
        // 判断两个链表是否相交
        if (stackA.peek() != stackB.peek()) {
            return null;
        } else {
            while (!stackA.empty() && !stackB.empty()) {
                if (stackA.peek() == stackB.peek()) {
                    common = stackA.pop();
                    stackB.pop();
                } else {
                    break;
                }
            }
        }
        return common;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists obj = new IntersectionOfTwoLinkedLists();
    }
}
// https://segmentfault.com/a/1190000003740979
// http://blog.csdn.net/nomasp/article/details/50572819
// http://www.cnblogs.com/grandyang/p/4128461.html
// http://blog.csdn.net/liuchonge/article/details/73556045
// http://blog.csdn.net/fengxinlinux/article/details/78885764
// http://blog.csdn.net/xiaofengcanyuexj/article/details/25505707