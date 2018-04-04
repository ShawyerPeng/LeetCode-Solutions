package linked_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.length == 0) return dummy.next;

        int len = lists.length;
        ListNode cur = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 把所有List的首节点（如果不为空）都放入优先队列中
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (queue.size() != 0) {
            // 从优先队列中取出一个最小的
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) queue.add(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists obj = new MergeKSortedLists();
        ListNode[] lists = new ListNode[]{ListNode.buildListNode(new int[]{1, 4, 5, 7}),
                ListNode.buildListNode(new int[]{2, 3, 5, 8}),
                ListNode.buildListNode(new int[]{0, 4, 6, 9})};
        ListNode.printList(obj.mergeKLists(lists));
    }
}
