package depth_first_search;

import template.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 * 问题：要把一个有序数组转换成一棵二分查找树
 * 思路：选中点构造根节点，然后递归的构造左子树和右子树。
 */
/**
 * 二叉搜索树特点：小的值在左边，大的值在右边
 * 这样的结构有一个好处是很容易获得最大值（Maximum）、最小值（minimum）、某元素的前驱（Precursor）、某元素的后继（Successor）。
 * 最大值：树的最右节点。
 * 最小值：树的最左节点。
 * 某元素前驱：左子树的最右。
 * 某元素的后继：右子树的最左。
 * <p>
 * 思路：
 * 1.找到排序数组的中点
 * 2.递归生成左子树和右子树
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        // 每层递归函数取中间元素，作为当前根和赋上结点值
        TreeNode root = new TreeNode(nums[mid]);

        // 然后左右节点接上左右区间的递归函数返回值
        // 根节点左边区域的中间节点便是左孩子，根节点的右边区域的中间节点便是右孩子
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree obj = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(obj.sortedArrayToBST(nums).val);
    }
}
// http://blog.csdn.net/linhuanmars/article/details/23904883