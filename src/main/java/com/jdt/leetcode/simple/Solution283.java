package com.jdt.leetcode.simple;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * @author jdt
 * @date 2023/8/19
 */
public class Solution283 {

    /**
     * 使用2个指针
     * 指针a 遇到0右移
     * 两个指针只要遇到一个非0的数字 进行交换，然后一起右移
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int a = 0, b = 0;
        while (a <= (nums.length - 1)) {
            if (nums[a] == 0) {
                a++;
            } else {
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
                a++;
                b++;
            }
        }
    }


    /**
     * 记录0的位置和变更后的位置
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
                count++;
            } else {
                if (!CollectionUtils.isEmpty(list)) {
                    nums[list.get(0)] = nums[i];
                    list.add(i);
                    list.remove(list.get(0));
                }
            }
        }
        if (count != 0) {
            for (int i = 1; i <= count; i++) {
                nums[nums.length - i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
