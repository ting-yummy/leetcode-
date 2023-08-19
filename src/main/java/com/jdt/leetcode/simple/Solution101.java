package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.TreeNode;

/**
 * 101. 对称二叉树
 * <p>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return match(root.left, root.right);
    }

    public static boolean match(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null && rightTree != null) {
            return false;
        }
        if (leftTree != null && rightTree == null) {
            return false;
        }
        if (leftTree.val != rightTree.val) {
            return false;
        }

        boolean result = match(leftTree.left, rightTree.right);
        if (!result) {
            return false;
        }
        return match(rightTree.left, leftTree.right);
    }

    public static void main(String[] args) {


//        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node5);
//        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2, null, node7);

        TreeNode root = new TreeNode(1, node2, node2);
        System.out.println(isSymmetric(root));
    }

}
