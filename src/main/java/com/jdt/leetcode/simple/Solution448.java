package com.jdt.leetcode.simple;

import java.util.*;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 *
 * @author jdt
 * @date 2023/8/19
 */
public class Solution448 {

    /**
     * 方式：哈希的数组替代
     * 有1 <= x <= n 个元素，
     * 遍历n个元素 进行计算(num -1)%n 的值，获取其本身应该在的位置 为啥进行减一是因为数组下标从0开始哦
     * 然后算出来的下标位置的值进行 +n 将其变大，但不会影响他进行取模运算
     * 所以修改过的值一定是会大于n的
     * 那么，再次进行遍历的时候如果位置上的值比n小 说明这个下标本身的值就是缺少的值，返回他下标就行。
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //拿到数组长度
        int n = nums.length;
        //进行取模增加
        for (int num : nums) {
            int x = (num - 1) % n; //计算出下标的位置
            nums[x] = nums[x] + n; //将原本下标的值+这个下标原本应该在的
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= i) {
                list.add(i + 1);
            }
        }
        return list;
    }


    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                array.add(i);
            }
        }
        return array;

    }

    public static void main(String[] args) {
        List<Integer> z = findDisappearedNumbers(new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7});
        for (Integer integer : z) {
            System.out.println(integer);
        }
    }
}
