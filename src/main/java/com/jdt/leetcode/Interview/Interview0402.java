package com.jdt.leetcode.Interview;

import com.jdt.leetcode.struct.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 *
 * @author jdt
 * @date 2023/8/21
 */
public class Interview0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return toTree(nums, 0, nums.length - 1);
    }

    private TreeNode toTree(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        //获取中间下标
        int middle = (leftIndex + rightIndex) / 2;
        //每次都以中间下标作为小树的根节点
        TreeNode middleNode = new TreeNode(nums[middle]);
        //比中间下标小的为左节点
        middleNode.left = toTree(nums, leftIndex, middle - 1);
        //比中间下标大的为右节点
        middleNode.right = toTree(nums, middle + 1, rightIndex);
        return middleNode;
    }

}
