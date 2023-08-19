package com.jdt.leetcode.simple;

import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * @author jdt
 * @date 2023/8/18
 */
public class Solution169 {
    public int majorityElement2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int count = nums.length / 2;
        //数据，出现的次数
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
            } else {
                int currentCount = value + 1;
                if (currentCount > count) {
                    return nums[i];
                }
                map.put(nums[i], currentCount);
            }
        }
        return 0;
    }

    //投票算法 需要2个参数
    // 一个记录当前最新的参数值a，
    // 另一个记录出现次数b，出现b+1，下一个值如果不是b就进行-1，为0的时候 a选择下一个第一个遇到的值进行
    //因为题目上说大于n/2次 所以b值最后只要大于0就一定是超过的了。
    public static int majorityElement(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        int data = 0;
        //
        for (int num : nums) {
            if (count == 0) {
                data = num;
                count++;
            } else {
                count += (data == num) ? 1 : -1;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 4}));
    }
}
