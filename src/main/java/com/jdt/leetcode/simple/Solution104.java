package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.TreeNode;

/**
 * 104. 二叉树的最大深度
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int size = 0;
        return depth(root, size);
    }

    public static int depth(TreeNode root, int size) {
        if (root == null) {
            return size;
        }
        size++;
        int rightSize = depth(root.right, size);
        int leftSize = depth(root.left, size);
        return leftSize >= rightSize ? leftSize : rightSize;
    }

    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, null, node9);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode root = new TreeNode(3, node9, node20);
        System.out.println(maxDepth(root));
    }


}
