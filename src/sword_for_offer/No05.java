package sword_for_offer;

import linked_list.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 问题：从尾到头打印链表。输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：
 * 思路 1：遍历链表，采用头插法将每个元素插入到 List 中
 * 思路 2：借助栈，遍历的时候入栈，由于数据结构中栈的特点是先进后出，所以遍历的过程中压栈，推栈，完了弹栈加到 ArrayList 中。
 * 思路 3：采用递归的方法，显示调用栈。（当链表非常长的时候，就会导致函数调用的层级很深，从而有可能导致函数调用栈溢出）
 */
public class No05 {
    /**
     * 用栈保存遍历结果
     */
    public List<Integer> printListFromTailToHead(ListNode head) {
        List<Integer> results = new ArrayList<>();
        if (head == null) return results;

        Stack<Integer> stack = new Stack<>();

        ListNode node = head;
        // 只要链表未到达表尾
        while (node != null) {
            // 就依次遍历链表并添加到Stack中
            stack.push(node.val);
            node = node.next;
        }
        // 只要栈不空
        while (!stack.isEmpty()) {
            // 就不断地将元素添加到List中，并出栈
            results.add(stack.pop());
        }
        return results;
    }

    /**
     * 头插法
     */
    public List<Integer> printListFromTailToHeadToucha(ListNode head) {
        ArrayList<Integer> results = new ArrayList<>();
        if (head == null) return results;

        ListNode node = head;
        while (node != null) {
            // 头插法
            results.add(0, node.val);
            node = node.next;
        }
        return results;
    }

    /**
     * 递归
     */
    public List<Integer> printListFromTailToHeadRec(ListNode head) {
        List<Integer> results = new ArrayList<>();
        if (head == null) return results;
        dfs(head, results);
        return results;
    }

    private void dfs(ListNode head, List<Integer> results) {
        if (head != null) {
            if (head.next != null) {
                // 因为要反过来输出链表，所以先递归输出后面的节点
                dfs(head.next, results);
            }
            // 再输出自身
            results.add(head.val);
        }
    }

    /**
     * 显式栈递归
     */


    public static void main(String[] args) {
        No05 obj = new No05();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(obj.printListFromTailToHead(head));
        System.out.println(obj.printListFromTailToHeadRec(head));
        System.out.println(obj.printListFromTailToHeadToucha(head));
    }
}
