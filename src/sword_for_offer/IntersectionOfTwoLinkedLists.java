package sword_for_offer;

import linked_list.ListNode;

import java.util.Stack;

/**
 * 问题：判断两个链表是否相交？如果相交，返回第一个相交的公共节点。
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while(headA != null){
            stackA.push(headA);
            headA = headA.next;
        }
        while(headB != null){
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
        ListNode headA = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode headB = ListNode.buildListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(obj.getIntersectionNode(headA, headB).val);
    }
}
