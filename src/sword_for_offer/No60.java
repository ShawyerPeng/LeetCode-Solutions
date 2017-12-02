package sword_for_offer;

import template.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288
 * 问题：把二叉树打印成多行。
 * 思路：
 */
public class No60 {
    List<List<Integer>> print(TreeNode pRoot) {
        List<List<Integer>> results = new ArrayList<>();
        if (pRoot == null) return results;

        Queue<TreeNode> newQueue = new LinkedList<>();
        newQueue.add(pRoot);
        int layerCount = 1; // 当前层的节点的总个数
        int upCount = 0;    // 当前已经便利过的本层的节点的个数
        int downCount = 0;  // 下一层的节点个数统计
        List<Integer> nodeList = new ArrayList<>();
        while (!newQueue.isEmpty()) {
            TreeNode tempNode = newQueue.poll();
            nodeList.add(tempNode.val);
            upCount++;

            // 若左右节点不为空，则将左右节点都添加进去
            if (tempNode.left != null) {
                newQueue.add(tempNode.left);
                downCount++;
            }
            if (tempNode.right != null) {
                newQueue.add(tempNode.right);
                downCount++;
            }

            // 看本层的节点是否已经遍历完
            if (upCount == layerCount) {
                ArrayList<Integer> tarList = new ArrayList<>();
                for (int i = 0; i < nodeList.size(); i++) {
                    tarList.add(nodeList.get(i));
                }
                results.add(tarList);

                // 清空nodeList数组
                for (int i = 0; i < layerCount; i++) {
                    nodeList.remove(0);
                }

                // 重置为零
                upCount = 0;
                // 因为要开始遍历下一层，要设置下一层的总个数给layerCount
                layerCount = downCount;
                // 开始遍历下一层时，就要统计下下层的个数大小
                downCount = 0;
            }
        }

        return results;
    }

    public static void main(String[] args) {

    }
}
// http://blog.csdn.net/shansusu/article/details/50131629
// http://blog.csdn.net/snow_7/article/details/51926279