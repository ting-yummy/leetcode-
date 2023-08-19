package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.TreeNode;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * <p>
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author jdt
 * @date 2023/8/19
 */
public class Solution226 {
    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode targeNode = new TreeNode(root.val);
        change(root, targeNode);
        return targeNode;
    }

    private static void change(TreeNode node, TreeNode targetNode) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            targetNode.right = new TreeNode(node.left.val);
            change(node.left, targetNode.right);
        }
        if (node.right != null) {
            targetNode.left = new TreeNode(node.right.val);
            change(node.right, targetNode.left);
        }
    }


    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        //[4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        invertTree(root);
    }
}
