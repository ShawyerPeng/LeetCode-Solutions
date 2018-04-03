package sword_for_offer;

/**
 * https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
 * 问题：二叉搜索树的后序遍历序列
 * 思路：
 */
public class No24 {
    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] sequence, int l, int r) {
        if (r <= l) return true;

        int root = sequence[r];

        // 左子树都小于根节点
        int i = l;
        for (; i < r; i++) {
            // 不满足左子树条件则跳出
            if (sequence[i] > root) break;
        }

        // 右子树都大于根节点
        int j = i;
        for (; j < r; j++) {
            if (sequence[j] < root)
                // 不满足右子树条件返回false
                return false;
        }

        boolean left = true;
        if (i > 0) left = judge(sequence, l, i - 1);

        boolean right = true;
        if (i < sequence.length - 1) right = judge(sequence, i, r - 1);

        return (left && right);
    }

    public static void main(String[] args) {
        No24 obj = new No24();
        System.out.println(obj.verifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8}));
    }
}
