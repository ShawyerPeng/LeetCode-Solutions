package sword_for_offer;

/**
 * https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba
 * 问题：复杂链表的复制
 * 思路：
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class No26 {
    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode currNode = pHead;
        while (currNode != null) {
            RandomListNode node = new RandomListNode(currNode.label);
            node.next = currNode.next;
            currNode.next = node;
            currNode = node.next;
        }
        currNode = pHead;
        while (currNode != null) {
            RandomListNode node = currNode.next;
            if (currNode.random != null) {
                node.random = currNode.random.next;
            }
            currNode = node.next;
        }
        // 拆分
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        currNode = pHead;
        while (currNode.next != null) {
            tmp = currNode.next;
            currNode.next = tmp.next;
            currNode = tmp;
        }
        return pCloneHead;
    }

    public static void main(String[] args) {
        No26 obj = new No26();
    }
}
