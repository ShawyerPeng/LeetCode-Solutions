//package tree;
//
//import template.TreeNode;
//
//import java.util.List;
//
///**
// * https://leetcode.com/problems/find-duplicate-subtrees
// * 问题：寻找重复子树
// * 思路：用到了后序遍历，还有数组序列化，并且建立序列化跟其出现次数的映射
// * 这样如果我们得到某个结点的序列化字符串，而该字符串正好出现的次数为 1，说明之前已经有一个重复树了
// * 我们将当前结点存入结果 res，这样保证了多个重复树只会存入一个结点
// */
//public class FindDuplicateSubtrees {
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
//// http://www.cnblogs.com/grandyang/p/7500082.html
//// http://storypku.com/2017/10/leetcode-question-652-find-duplicate-subtrees/