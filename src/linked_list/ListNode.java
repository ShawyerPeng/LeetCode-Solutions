package linked_list;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 判断链表是否为空
     */
    boolean isEmpty() {
        return next == null;
    }

    /**
     * 初始化链表
     */
    static ListNode getSingleList() {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        return head;
    }

    /**
     * 初始化链表
     */
    static ListNode buildListNode(int[] input) {
        ListNode first = null, last = null, newNode;
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                newNode = new ListNode(input[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
                    last = newNode;
                }

            }
        }
        return first;
    }

    /**
     * 打印链表
     */
    static void printList(ListNode node) {
        System.out.print("List:");
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print("-->");
            }
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 在指定位置增加节点
     */
    static ListNode addNode(ListNode head, ListNode add, int id) {
        if (id == 0) {
            add.next = head;
            head = add;
        } else {
            while (head.next != null && id > 1) {//寻找节点增加的位置
                head = head.next;
                id--;
            }
            add.next = head.next;
            head.next = add;
        }
        return head;
    }

    /**
     * 删除指定值的节点（删除链表中等于给定值val的所有节点）
     */
    static ListNode removeElements(ListNode head, int val) {
        // 判断 head 是不是空，为空就直接返回 null
        if (head == null) return null;

        ListNode p = head;
        ListNode q = head.next;

        // 从head.next开始循环遍历，删除等于val的元素
        while (q != null) {
            //
            if (q.val == val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }

        // 判断head是否和val相等。若相等，head = head.next
        // head只是一个节点，只要判断一次
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    /**
     * 删除指定位置的节点
     */
    static ListNode removeElementsAt(ListNode head, int id) {
        // 判断 head 是不是空，为空就直接返回 null
        if (head == null) return null;

        ListNode p = head;
        ListNode q = head.next;

        // 从head.next开始循环遍历，删除等于val的元素
        while (q != null) {
            //
            if (q.val == id) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }

        // 判断head是否和val相等。若相等，head = head.next
        // head只是一个节点，只要判断一次
        if (head.val == id) {
            return head.next;
        }
        return head;
    }

    /**
     * 顺序查找
     */



    public static void main(String[] args) {
        ListNode head = ListNode.buildListNode(new int[]{1,2,4,8,16});
        ListNode.addNode(head, new ListNode(32), 5);
        printList(head);
    }
}
