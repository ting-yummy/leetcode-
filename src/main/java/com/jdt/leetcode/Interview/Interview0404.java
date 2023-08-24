package com.jdt.leetcode.Interview;

import com.jdt.leetcode.struct.TreeNode;

/**
 * 面试题 04.04. 检查平衡性
 * 提示
 * 简单
 * 109
 * 相关企业
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0404 {

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    /**
     * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，
     * 先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。
     * 如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），
     * 否则返回 −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。

     * @param node
     * @return
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right);
    }
}
