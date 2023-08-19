package com.jdt.leetcode.simple;

import com.jdt.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * <p>
 * 示例
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author jdt
 * @date 2023/8/17
 */
public class Solution94 {

    /**
     * 二叉树
     * 1
     * 2     3
     * 4   5  6  7
     * 二叉树先序排序：1-2-4-5-3-6-7
     * 先查找根节点，再找其左节点，若其有子节点，先访问他的左节点 在访问右节点 以此类推
     * 二叉树中序排序  4-2-5-1-6-3-7
     * 先访问左节点，在访问根节点，在访问右子节点
     * 二叉树后序排序 4-5-2-6-7-3-1
     * 先访问左节点，在访问右节点 最后访问根节点
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        order(root, list);
        return list;

    }

    public static void order(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        order(root.left, list);
        list.add(root.val);
        order(root.right, list);
    }

    public static void main(String[] args) {

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode root = new TreeNode(1, node2, node3);

        List<Integer> list = inorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


}
